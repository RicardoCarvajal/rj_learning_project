package com.rcarvajal.app.service.infraestructure.web.telegram;

import com.rcarvajal.app.service.conf.ConfProperties;
import com.rcarvajal.app.service.function.dto.MessageBot;
import com.rcarvajal.app.service.infraestructure.web.Delivery;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class TelegramDelivery implements Delivery<MessageBot> {

    private final RestTemplate restTemplate;

    private final ConfProperties confProperties;

    public TelegramDelivery(ConfProperties confProperties) {
        this.confProperties = confProperties;
        this.restTemplate = new RestTemplate();
    }

    @Override
    public void send(MessageBot model) {

        if (this.confProperties.getUsers().contains(model.getId())) {
            System.out.println("Pass here");
            String baseUrl = "https://api.telegram.org/bot" + this.confProperties.getCredentialTelegram();
            String uri = UriComponentsBuilder.fromHttpUrl(baseUrl)
                    .pathSegment("sendMessage")
                    .queryParam("chat_id", model.getId())
                    .queryParam("text", model.getText())
                    .toUriString();

            try {
                String response = restTemplate.postForObject(uri, null, String.class);
                System.out.println(response);
            } catch (Exception e) {
                System.out.println("Pass error");
                System.err.println(e.getMessage());
            }
        }

    }
}