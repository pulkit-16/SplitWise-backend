package com.example.splitwise_begginer.commands;

import com.example.splitwise_begginer.controller.UserController;
import com.example.splitwise_begginer.dtos.CreateUserRequestDtos;
import com.example.splitwise_begginer.dtos.CreateUserResponseDtos;
import com.example.splitwise_begginer.dtos.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateUserCommand implements Command{


    private UserController userController;
    @Autowired
    public CreateUserCommand(UserController userController) {
        this.userController = userController;
    }

    @Override
    public boolean canExecute(String input) {
        if(!input.startsWith("create-user"))
            return false;
        else if(input.split(" ").length !=4) // white space exculed krk length
            return false;

        return true;
    }

    @Override
    public void execute(String input) {
        // make dtos and call controller
        String[] parts = input.split(" ");// createUser,name,Uname,Password
        CreateUserRequestDtos requestDtos = new CreateUserRequestDtos();
        requestDtos.setName(parts[1]);
        requestDtos.setUserName(parts[2]);
        requestDtos.setPassword(parts[3]);


        CreateUserResponseDtos responseDtos = userController.createUser(requestDtos);

        if(responseDtos.getResponseStatus().equals(ResponseStatus.SUCCESS)){
            System.out.println("User created successfully with id " + responseDtos.getUserId());
        }
        else{
            System.out.println("User creation failed with message" +responseDtos.getMessage());

        }

    }
}
