package com.example.splitwise_begginer.commands;

public interface Command {
    boolean canExecute(String input);
    void execute(String input);
}
