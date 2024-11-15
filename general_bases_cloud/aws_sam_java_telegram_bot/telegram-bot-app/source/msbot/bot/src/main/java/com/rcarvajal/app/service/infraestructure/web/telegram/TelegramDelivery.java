package com.rcarvajal.app.service.infraestructure.web.telegram;

import com.rcarvajal.app.service.function.dto.BodyRequest;
import com.rcarvajal.app.service.infraestructure.entity.MessageBot;
import com.rcarvajal.app.service.infraestructure.web.Delivery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Primary
@Component
public class TelegramDelivery implements Delivery {

    private final WebClient webClient;

    public TelegramDelivery(WebClient webClient) {
        this.webClient = webClient;
    }


    @Override
    public Mono<String> send(BodyRequest bodyRequest) {
        MessageBot messageBot = MessageBot.builder()
                .withId(String.valueOf(bodyRequest.getMessage().getChat().getId()))
                .withText(bodyRequest.getMessageSystem()).build();

        log.info("Se envia texto: [{}] al usuario {}", messageBot.getText(), bodyRequest.getMessage().getChat().getId());

        return webClient.post()
                .uri(uriBuilder -> uriBuilder
                        .path("/sendMessage")
                        .queryParam("chat_id", messageBot.getId())
                        .queryParam("text", messageBot.getText())
                        .build())
                .retrieve()
                .bodyToMono(String.class).map(response -> {
                    return "Mensaje enviado";
                });

    }

    @Override
    public Mono<String> deleteWebhook() {

        log.info("Se desactivara el Webhook de telegram");

        return webClient.post()
                .uri(uriBuilder -> uriBuilder
                        .path("/deleteWebhook")
                        .queryParam("drop_pending_updates", "True")
                        .build())
                .retrieve()
                .bodyToMono(String.class).map(response -> {
                    return "Webhook desactivado";
                });

    }
}