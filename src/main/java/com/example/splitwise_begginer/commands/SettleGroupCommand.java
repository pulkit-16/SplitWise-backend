package com.example.splitwise_begginer.commands;

import com.example.splitwise_begginer.controller.GroupController;
import com.example.splitwise_begginer.controller.UserController;
import com.example.splitwise_begginer.dtos.*;
import com.example.splitwise_begginer.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class SettleGroupCommand implements Command{
    private GroupController groupController;

    @Autowired
    public SettleGroupCommand(GroupController groupController) {
        this.groupController = groupController;
    }

    @Override
    public boolean canExecute(String input) {
        if(!input.startsWith("settle-group"))
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
        SettleGroupRequestDtos requestDtos = new SettleGroupRequestDtos();
        requestDtos.setGroupName(parts[1]);


        SettleGroupResponseDtos responseDtos = groupController.settleGroup(requestDtos);

        if(responseDtos.getResponseStatus().equals(ResponseStatus.SUCCESS)){
            List<Transaction>transactions = responseDtos.getTransactions();
            for(Transaction t :transactions){
                System.out.println(t);
            }
        }
        else{
            System.out.println("Group settlement failed  " +responseDtos.getMessage());

        }

    }
}
