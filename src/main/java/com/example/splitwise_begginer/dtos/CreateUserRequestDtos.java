package com.example.splitwise_begginer.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequestDtos {
    private String name;
    private String userName;
    private String password;
}
