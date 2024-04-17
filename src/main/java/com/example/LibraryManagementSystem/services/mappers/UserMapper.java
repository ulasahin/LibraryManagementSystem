package com.example.LibraryManagementSystem.services.mappers;

import com.example.LibraryManagementSystem.entities.User;
import com.example.LibraryManagementSystem.services.dtos.requests.user.AddUserRequest;
import com.example.LibraryManagementSystem.services.dtos.requests.user.UpdateUserRequest;
import com.example.LibraryManagementSystem.services.dtos.responses.user.AddUserResponse;
import com.example.LibraryManagementSystem.services.dtos.responses.user.DeleteUserResponse;
import com.example.LibraryManagementSystem.services.dtos.responses.user.GetUserResponse;
import com.example.LibraryManagementSystem.services.dtos.responses.user.UpdateUserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {


    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    //add mapping
    User userFromAddRequest(AddUserRequest request);
    AddUserResponse addResponseFromUser(User user);
    //

    //update mapping
    User userFromUpdateRequest(UpdateUserRequest request);

    UpdateUserResponse updateResponseFromUser(User user);

    //

    //delete mapping
    User userFromDeleteRequest(int id);
    DeleteUserResponse deleteResponseFromUser(User user);

    GetUserResponse getUserResponseFromUser(User user);
}
