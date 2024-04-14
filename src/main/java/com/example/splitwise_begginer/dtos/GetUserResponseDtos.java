package com.example.splitwise_begginer.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUserResponseDtos {
    private String name;
    private String userName;
    //not returning password->sensitive info(do  not return whole model)
    private ResponseStatus responseStatus;
    private String message;
}
