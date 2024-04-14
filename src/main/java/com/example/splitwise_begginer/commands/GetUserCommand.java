package com.example.splitwise_begginer.commands;

import com.example.splitwise_begginer.controller.UserController;
import com.example.splitwise_begginer.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetUserCommand implements Command{

    private UserController userController;
    @Autowired
    public GetUserCommand(UserController userController){
        this.userController=userController;
    }
    @Override
    public boolean canExecute(String input) {
        if(!input.startsWith("get-user"))
            return false;
        else if(input.split(" ").length !=2) // white space exculed krk length
            return false;

        // check validation if input is  Integer or not...

        return true;
    }

    @Override
    public void execute(String input) {
        // make dtos and call controller

        String[] parts = input.split(" ");                  // createUser,name,Uname,Password
        GetUserRequestDtos requestDtos = new GetUserRequestDtos();
        requestDtos.setUserId(Long.parseLong(parts[1]));


        GetUserResponseDtos responseDtos = userController.getUser(Long.parseLong(parts[1]));

        if(responseDtos.getResponseStatus().equals(ResponseStatus.SUCCESS)){
            System.out.println("Name = " + responseDtos.getName());
            System.out.println("UserName = " + responseDtos.getUserName());
        }
        else{
            System.out.println("User retrieval failed with message " +responseDtos.getMessage());

        }

    }
}
