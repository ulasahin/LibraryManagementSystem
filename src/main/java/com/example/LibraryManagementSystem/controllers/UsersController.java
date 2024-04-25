package com.example.LibraryManagementSystem.controllers;

import com.example.LibraryManagementSystem.services.abstracts.UserService;
import com.example.LibraryManagementSystem.services.dtos.requests.user.AddUserRequest;
import com.example.LibraryManagementSystem.services.dtos.requests.user.UpdateUserRequest;
import com.example.LibraryManagementSystem.services.dtos.responses.user.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UsersController {
    private UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ListUserResponse> getAll(){
        return userService.getAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddUserResponse add(@RequestBody @Valid AddUserRequest request){
        return userService.add(request);
    }
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UpdateUserResponse update(@RequestBody @Valid UpdateUserRequest request){return userService.update(request);}
    @DeleteMapping
    public DeleteUserResponse delete(@RequestParam  int id){
        return userService.delete(id);
    }
    @GetMapping(value ="/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetUserResponse getByIdFromUser(@PathVariable int id){
        return userService.getById(id);
    }
}
