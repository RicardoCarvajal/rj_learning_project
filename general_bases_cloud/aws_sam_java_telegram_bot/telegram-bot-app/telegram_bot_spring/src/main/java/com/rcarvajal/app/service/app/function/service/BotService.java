package com.rcarvajal.app.service.app.function.service;

import com.rcarvajal.app.service.app.function.dto.FunctionRequest;
import com.rcarvajal.app.service.app.function.dto.MessageBot;
import com.rcarvajal.app.service.infraestructure.web.Delivery;
import org.springframework.stereotype.Service;

@Service
public class BotService {

    private final Delivery<MessageBot> delivery;

    public BotService(Delivery<MessageBot> delivery) {
        this.delivery = delivery;
    }

    public String getString(FunctionRequest request){
        System.out.println("Doing something");
        delivery.send(MessageBot.builder().withId(request.getId()).withText(request.getMessage()).build());
        return request.getMessage();
    }
}
