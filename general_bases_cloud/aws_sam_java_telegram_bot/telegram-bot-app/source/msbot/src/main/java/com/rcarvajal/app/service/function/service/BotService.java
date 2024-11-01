package com.rcarvajal.app.service.function.service;

import com.rcarvajal.app.service.function.dto.BodyRequest;
import com.rcarvajal.app.service.function.dto.FunctionRequest;
import com.rcarvajal.app.service.function.dto.MessageBot;
import com.rcarvajal.app.service.function.mapper.FunctionRequestMapper;
import com.rcarvajal.app.service.infraestructure.web.Delivery;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BotService {

    private final Delivery<MessageBot> delivery;

    private final FunctionRequestMapper requestMapper;

    public BotService(Delivery<MessageBot> delivery, FunctionRequestMapper requestMapper) {
        this.delivery = delivery;
        this.requestMapper = requestMapper;
    }

    public String sendMessage(FunctionRequest request) {

        BodyRequest body = requestMapper.getBody(request);
        String id = String.valueOf(body.getMessage().getFrom().getId());
        String message = body.getMessage().getText();
        if (message.equalsIgnoreCase("/start")) {
            System.out.println("Doing something");
            System.out.println("request.getId() " + id);
            System.out.println("request.getMessage() " + message);
            delivery.send(MessageBot.builder().withId(id).withText("Doing something " + UUID.randomUUID()).build());
        }
        return message;
    }
}
