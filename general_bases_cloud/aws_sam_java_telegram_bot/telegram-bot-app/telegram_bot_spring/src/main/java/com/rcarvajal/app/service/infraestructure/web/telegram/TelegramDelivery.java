package com.rcarvajal.app.service.infraestructure.web.telegram;

import com.rcarvajal.app.service.app.function.dto.MessageBot;
import com.rcarvajal.app.service.infraestructure.web.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class TelegramDelivery implements Delivery<MessageBot> {

    private final WebClient webClient;

    public TelegramDelivery(WebClient webClient) {
        webClient = WebClient.builder().baseUrl("https://api.telegram.org/bot8191587699:AAFw7grYGbHklIBPAhSZKN0svbbSH6kGpq0").build();
        this.webClient = webClient;
    }

    @Override
    public void send(MessageBot model) {
        System.out.println("Pass here");
        webClient.post()
                .uri(uriBuilder -> uriBuilder
                        .path("/sendMessage")
                        .queryParam("chat_id", model.getId())
                        .queryParam("text", model.getText())
                        .build())
                .retrieve()
                .bodyToMono(String.class).onErrorResume(e -> {
                    System.out.println("Pass error");
                    System.out.println(""+e);
                    return Mono.just("Hello");
                }).subscribe();
    }
}
