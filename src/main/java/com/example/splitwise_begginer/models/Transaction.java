package com.example.splitwise_begginer.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//no Entity  -> dont want to store in Db , only show to user
public class Transaction {
    private String from;
    private String to;
    private int amount;


    @Override
    public String toString() {
        return from +" should pay "+amount+ "Rs to "+ to +"\n";
    }

    public Transaction(String from, String to, int amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }
}
