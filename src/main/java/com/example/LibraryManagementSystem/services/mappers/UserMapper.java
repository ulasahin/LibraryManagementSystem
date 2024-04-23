package com.example.LibraryManagementSystem.services.mappers;

import com.example.LibraryManagementSystem.entities.User;
import com.example.LibraryManagementSystem.services.dtos.requests.user.AddUserRequest;
import com.example.LibraryManagementSystem.services.dtos.requests.user.UpdateUserRequest;
import com.example.LibraryManagementSystem.services.dtos.responses.user.AddUserResponse;
import com.example.LibraryManagementSystem.services.dtos.responses.user.DeleteUserResponse;
import com.example.LibraryManagementSystem.services.dtos.responses.user.GetUserResponse;
import com.example.LibraryManagementSystem.services.dtos.responses.user.UpdateUserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {


    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    //add mapping
    User userFromAddRequest(AddUserRequest request);
    AddUserResponse userFromAddResponse(User user);
    //

    //update mapping
    @Mapping(target = "id", ignore = true)
    User userFromUpdateRequest(UpdateUserRequest request, @MappingTarget User user);

    UpdateUserResponse userFromUpdateResponse(User user);

    //

    //delete mapping
    DeleteUserResponse userFromDeleteResponse(User user);

    GetUserResponse getUserResponseFromUser(User user);
}
