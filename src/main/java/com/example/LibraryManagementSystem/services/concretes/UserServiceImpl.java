package com.example.LibraryManagementSystem.services.concretes;

import com.example.LibraryManagementSystem.core.utils.exception.BusinessException;
import com.example.LibraryManagementSystem.entities.User;
import com.example.LibraryManagementSystem.repositories.UserRepository;
import com.example.LibraryManagementSystem.services.abstracts.UserService;
import com.example.LibraryManagementSystem.services.dtos.requests.user.AddUserRequest;
import com.example.LibraryManagementSystem.services.dtos.requests.user.UpdateUserRequest;
import com.example.LibraryManagementSystem.services.dtos.responses.user.*;
import com.example.LibraryManagementSystem.services.mappers.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public AddUserResponse add(AddUserRequest request) {

        userNameWithSameNameShouldNotExist(request.getUserName());
        User user = UserMapper.INSTANCE.userFromAddRequest(request);
        user = userRepository.save(user);

        AddUserResponse addUserResponse = UserMapper.INSTANCE.userFromAddResponse(user);
        return addUserResponse;
    }

    @Override
    public UpdateUserResponse update(UpdateUserRequest request) {
        User existingUser = userRepository.findById(request.getId())
                .orElseThrow(() -> new BusinessException("Güncellenmek istenen kullanıcı bulunamadı!"));
        for (Field field : UpdateUserRequest.class.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                Object value = field.get(request);
                if (value != null && !String.valueOf(value).isEmpty()) {
                    Field userField = User.class.getDeclaredField(field.getName());
                    userField.setAccessible(true);
                    userField.set(existingUser, value);
                }
            } catch (IllegalAccessException | NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        existingUser = userRepository.save(existingUser);

        UpdateUserResponse updateUserReponse = UserMapper.INSTANCE.userFromUpdateResponse(existingUser);
        return updateUserReponse;
    }

    @Override
    public DeleteUserResponse delete(int id) {

        User user = userRepository.findById(id).orElseThrow(() -> new BusinessException("Bu id'ye sahip kullanıcı bulunamadı!"));
        DeleteUserResponse deleteUserResponse = UserMapper.INSTANCE.userFromDeleteResponse(user);
        userRepository.delete(user);
        return deleteUserResponse;
    }

    @Override
    public GetUserResponse getById(int id) {
        User user = userRepository.findById(id).orElseThrow();
        GetUserResponse getUserResponse = UserMapper.INSTANCE.getUserResponseFromUser(user);
        return getUserResponse;

    }

    @Override
    public List<ListUserResponse> getAll() {
        List<User> users = userRepository.findAll();
       return users.stream().map(u -> new ListUserResponse(u.getId(),u.getUserName(),u.getEmail())).toList();

    }
    private void userNameWithSameNameShouldNotExist(String userName){
        Optional<User> userWithSameName = userRepository.findByUserNameIgnoreCase(userName);
        if (userWithSameName.isPresent()){
            throw new BusinessException("Bu isimde bir kullanıcı zaten var.");
        }
    }
}
