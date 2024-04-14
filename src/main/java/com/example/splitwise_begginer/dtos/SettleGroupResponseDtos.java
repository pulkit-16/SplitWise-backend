package com.example.splitwise_begginer.dtos;

import com.example.splitwise_begginer.models.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleGroupResponseDtos {
    private List<Transaction>transactions;
    private ResponseStatus responseStatus;
    private String message;
}
