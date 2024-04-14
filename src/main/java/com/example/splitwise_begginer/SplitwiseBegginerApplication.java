package com.example.splitwise_begginer;

import com.example.splitwise_begginer.commands.CommandRegistery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SplitwiseBegginerApplication implements CommandLineRunner {
    // 3 req will require 6 dtos
    // createUser ->  <name> ,<uname> , <password>
    //getUser     ->  <userID>
    //settleGroup ->  <groupName>
    private CommandRegistery commandRegistery;
    @Autowired
    public SplitwiseBegginerApplication(CommandRegistery commandRegistery){
        this.commandRegistery = commandRegistery;
    }


    public static void main(String[] args) {
        SpringApplication.run(SplitwiseBegginerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while(true){
            String input = sc.nextLine();
            if(input.equals("quit")){
                break;
            }
            else{
                commandRegistery.process(input);
            }
        }

    }

}