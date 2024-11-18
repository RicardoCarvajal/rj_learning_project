package com.rcarvajal.app.service.function.service.implementation;

import com.rcarvajal.app.service.conf.ConfProperties;
import com.rcarvajal.app.service.function.bedrock.InvokeModel;
import com.rcarvajal.app.service.function.dto.BodyRequest;
import com.rcarvajal.app.service.function.service.BotService;
import com.rcarvajal.app.service.infraestructure.web.Delivery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@Primary
public class BotServicePrimary implements BotService {

    private final Delivery delivery;

    private final ConfProperties confProperties;

    private final InvokeModel converse;

    public BotServicePrimary(Delivery delivery, ConfProperties confProperties, InvokeModel converse) {
        this.delivery = delivery;
        this.confProperties = confProperties;
        this.converse = converse;
    }


    public Mono<String> sendMessage(BodyRequest body) {
        Long id = body.getMessage().getChat().getId();
        String message = body.getMessage().getText();
        log.info("Comando ingresado por usuario {}", message);
        if (this.confProperties.getUsers().compareTo(id) == 0) {
            if (message.compareTo("/start") == 0) {
                body.setMessageSystem("Bienvenido al chatbot de prueba");
            } else if (message.startsWith("/request")) {
                body.setMessageSystem(converse.generateResponse(message + " - la respuesta no puede tener mas de 3000 caracteres"));
            }
            return delivery.send(body);
        } else {
            log.info("Usuario {} no autorizado", id);
            return delivery.deleteWebhook();
        }
    }
}
