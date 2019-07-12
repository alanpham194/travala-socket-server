package com.travala.socketserver.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.travala.socketserver.dto.MessageDTO;
import com.travala.socketserver.services.AuthenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {
    @Autowired
    AuthenService authenService;

    @MessageMapping("/receipt/{id}")
    @SendTo("/subscribe/receipt/{id}")
    public JsonNode greeting(MessageDTO message) throws Exception {
        //authen
        authenService.authen(message.getToken());
        return message.getData();
    }
}
