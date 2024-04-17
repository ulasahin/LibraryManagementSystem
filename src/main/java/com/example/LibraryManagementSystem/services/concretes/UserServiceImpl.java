package com.example.LibraryManagementSystem.services.concretes;

import com.example.LibraryManagementSystem.entities.User;
import com.example.LibraryManagementSystem.repositories.UserRepository;
import com.example.LibraryManagementSystem.services.abstracts.UserService;
import com.example.LibraryManagementSystem.services.dtos.requests.user.AddUserRequest;
import com.example.LibraryManagementSystem.services.dtos.requests.user.UpdateUserRequest;
import com.example.LibraryManagementSystem.services.dtos.responses.user.*;
import com.example.LibraryManagementSystem.services.mappers.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;


    @Override
    public AddUserResponse add(AddUserRequest request) {

        User user = UserMapper.INSTANCE.userFromAddRequest(request);
        user = userRepository.save(user);

        AddUserResponse addUserResponse = UserMapper.INSTANCE.addResponseFromUser(user);
        return addUserResponse;
    }

    @Override
    public UpdateUserResponse update(UpdateUserRequest request) {
        User user = UserMapper.INSTANCE.userFromUpdateRequest(request);
        user = userRepository.save(user);

        UpdateUserResponse updateUserReponse = UserMapper.INSTANCE.updateResponseFromUser(user);
        return updateUserReponse;
    }

    @Override
    public DeleteUserResponse delete(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Bu id'ye sahip kullanıcı bulunamadı !"));
        DeleteUserResponse deleteUserResponse = UserMapper.INSTANCE.deleteResponseFromUser(user);
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
}
