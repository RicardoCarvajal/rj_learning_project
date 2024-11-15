package com.rcarvajal.app.service.function.service.implementation;

import com.rcarvajal.app.service.conf.ConfProperties;
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

    public BotServicePrimary(Delivery delivery, ConfProperties confProperties) {
        this.delivery = delivery;
        this.confProperties = confProperties;
    }


    public Mono<String> sendMessage(BodyRequest body) {
        Long id = body.getMessage().getChat().getId();
        String message = body.getMessage().getText();
        if (message.equalsIgnoreCase("/start")) {
            log.info("Comando ingresado por usuario {}", message);
            if (this.confProperties.getUsers().compareTo(id) == 0) {
                log.info("Usuario {} autorizado", id);
                //TODO Logica de servicio principal
                log.info("TODO Logica de servicio principal");
                body.setMessageSystem("Executed");
                return delivery.send(body);
            } else {
                log.info("Usuario {} no autorizado", id);
                return delivery.deleteWebhook();
            }
        }
        return Mono.error(new Exception("Command not found"));
    }
}
