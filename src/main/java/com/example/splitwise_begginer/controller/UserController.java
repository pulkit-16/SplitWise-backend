package com.example.splitwise_begginer.controller;

import com.example.splitwise_begginer.dtos.*;
import com.example.splitwise_begginer.dtos.ResponseStatus;
import com.example.splitwise_begginer.models.User;
import com.example.splitwise_begginer.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private  UserServices userServices;

    @Autowired
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping("/user/create/")
    public CreateUserResponseDtos createUser(@RequestBody() CreateUserRequestDtos requestDto){
        CreateUserResponseDtos responseDtos = new CreateUserResponseDtos();
        try{
            User savedUser = userServices.createUser(requestDto.getName(), requestDto.getUserName(),
                                                        requestDto.getPassword());
         //   responseDtos = new CreateUserResponseDtos(savedUser);
            responseDtos.setUserId(savedUser.getId());
            responseDtos.setMessage("User created successfully ");
            responseDtos.setResponseStatus(ResponseStatus.SUCCESS);
        }

       catch (Exception ex){
        responseDtos.setMessage(ex.getMessage());
        responseDtos.setResponseStatus(ResponseStatus.FAILURE);
                     }
        return responseDtos;
    }

    @GetMapping("/user/get/")
    public GetUserResponseDtos getUser(@RequestParam() Long userId){ //GetUserRequestDtos requestDto)
        GetUserResponseDtos responseDtos = new GetUserResponseDtos();
        try{
            User user = userServices.getUser(userId);

            responseDtos.setMessage("User found successfully ");
            responseDtos.setResponseStatus(ResponseStatus.SUCCESS);

            responseDtos.setName(user.getName());
            responseDtos.setUserName(user.getUserName());
        }
        catch (Exception ex){
            responseDtos.setMessage(ex.getMessage());
            responseDtos.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDtos;
    }
}
