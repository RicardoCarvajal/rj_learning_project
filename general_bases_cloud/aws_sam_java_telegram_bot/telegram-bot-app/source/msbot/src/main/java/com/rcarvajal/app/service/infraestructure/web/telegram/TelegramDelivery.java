package com.rcarvajal.app.service.infraestructure.web.telegram;

import com.rcarvajal.app.service.conf.ConfProperties;
import com.rcarvajal.app.service.function.dto.BodyRequest;
import com.rcarvajal.app.service.infraestructure.entity.MessageBot;
import com.rcarvajal.app.service.infraestructure.web.Delivery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Primary
@Component
public class TelegramDelivery implements Delivery {

    private final RestTemplate restTemplate;

    private final ConfProperties confProperties;

    public TelegramDelivery(ConfProperties confProperties) {
        this.confProperties = confProperties;
        this.restTemplate = new RestTemplate();
    }

    @Override
    public void send(BodyRequest bodyRequest) {

        MessageBot messageBot = MessageBot.builder()
                .withId(String.valueOf(bodyRequest.getMessage().getFrom().getId()))
                .withText(bodyRequest.getMessageSystem()).build();

        log.info("Se envia texto: [{}] al usuario {}", messageBot.getText(), bodyRequest.getMessage().getFrom().getId());

        String baseUrl = "https://api.telegram.org/bot" + this.confProperties.getCredentialTelegram();

        String uri = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .pathSegment("sendMessage")
                .queryParam("chat_id", messageBot.getId())
                .queryParam("text", messageBot.getText())
                .toUriString();

        log.info(uri);

        try {
            String response = restTemplate.postForObject(uri, null, String.class);
            log.info("Respuesta de telegram {}", response);
        } catch (Exception e) {
            log.error("Error en el envio a telegram {}", e.getMessage());
        }


    }
}