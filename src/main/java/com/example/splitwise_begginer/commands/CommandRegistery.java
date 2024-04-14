package com.example.splitwise_begginer.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CommandRegistery {
    private List<Command> commands = new ArrayList<>();

    @Autowired
    public CommandRegistery(CreateUserCommand createUserCommand,GetUserCommand getUserCommand,
                     SettleGroupCommand settleGroupCommand){
            this.commands.add(createUserCommand);
            this.commands.add(getUserCommand);
            this.commands.add(settleGroupCommand);
          }
    public void process(String input){
        for(Command command : commands){
            if(command.canExecute(input)==true){
                command.execute(input);
                break;
            }
        }
    }
}
