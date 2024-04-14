package com.example.splitwise_begginer.dtos;

import com.example.splitwise_begginer.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserResponseDtos {
   // private User _user;
    private Long userId;
    private ResponseStatus responseStatus;
    private String message;

//    public CreateUserResponseDtos(User _user) {
//
//        if(_user!=null){
//            this._user = _user;
//            setUserId(_user.getId());
//            setMessage("User created successfully ");
//            setResponseStatus(ResponseStatus.SUCCESS);
//        }
//        else{
//            setResponseStatus(ResponseStatus.FAILURE);
//        }
//    }

}
