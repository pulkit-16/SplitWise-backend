package com.example.splitwise_begginer.controller;

import com.example.splitwise_begginer.dtos.ResponseStatus;
import com.example.splitwise_begginer.dtos.SettleGroupRequestDtos;
import com.example.splitwise_begginer.dtos.SettleGroupResponseDtos;
import org.springframework.stereotype.Controller;

@Controller
public class GroupController {
    public SettleGroupResponseDtos settleGroup(SettleGroupRequestDtos requestDto){
        SettleGroupResponseDtos responseDTO = new SettleGroupResponseDtos();
        responseDTO.setMessage("Not implemented yet");
        responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        return responseDTO;

    }

}
