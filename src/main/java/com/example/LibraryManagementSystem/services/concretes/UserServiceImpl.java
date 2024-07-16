package com.example.LibraryManagementSystem.services.concretes;

import com.example.LibraryManagementSystem.core.exceptionhandling.exception.types.BusinessException;
import com.example.LibraryManagementSystem.model.entities.User;
import com.example.LibraryManagementSystem.repositories.UserRepository;
import com.example.LibraryManagementSystem.services.abstracts.UserService;
import com.example.LibraryManagementSystem.services.dtos.requests.user.AddUserRequest;
import com.example.LibraryManagementSystem.services.dtos.requests.user.UpdateUserRequest;
import com.example.LibraryManagementSystem.services.dtos.responses.user.*;
import com.example.LibraryManagementSystem.services.mappers.UserMapper;
import com.example.LibraryManagementSystem.services.rules.UserBusinessRule;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private  UserRepository userRepository;
    @Autowired
    private UserBusinessRule userBusinessRule;

    @Override
    public AddUserResponse add(AddUserRequest request) {
        userBusinessRule.userNameWithSameNameShouldNotExist(request.getName());
        User user = UserMapper.INSTANCE.userFromAddRequest(request);
        user = userRepository.save(user);

        AddUserResponse addUserResponse = UserMapper.INSTANCE.userFromAddResponse(user);
        return addUserResponse;
    }

    @Override
    public UpdateUserResponse update(UpdateUserRequest request) {
        User existingUser = userRepository.findById(request.getId())
                .orElseThrow(() -> new BusinessException("Güncellenmek istenen kullanıcı bulunamadı!"));

        UserMapper.INSTANCE.userFromUpdateRequest(request, existingUser);
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
       return users.stream().map(u -> new ListUserResponse(u.getId(),u.getName(),u.getEmail())).toList();

    }

    @Override
    public User findById(int id) {
       return userRepository.findById(id).orElseThrow(() -> new BusinessException("Böyle bir kullanıcı bulunamamıştır."));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow();
    }
}
