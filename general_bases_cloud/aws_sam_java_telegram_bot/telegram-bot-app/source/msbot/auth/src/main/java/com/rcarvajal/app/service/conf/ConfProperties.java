package com.rcarvajal.app.service.conf;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;

import java.util.Optional;

@Configuration
public class ConfProperties {

    private final ObjectMapper objectMapper;

    @Value("${aws.secretsmanager.secretwebhooktoken}")
    private String secretWebHookToken;

    public ConfProperties(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    private Optional<JsonNode> getSecretValue(String secretID) {
        try {
            SecretsManagerClient secretsClient = SecretsManagerClient.builder()
                    .build();

            GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder()
                    .secretId(secretID)
                    .build();

            GetSecretValueResponse getSecretValueResponse = secretsClient.getSecretValue(getSecretValueRequest);

            secretsClient.close();

            return Optional.of(objectMapper.readTree(getSecretValueResponse.secretString()));

        } catch (Exception e) {
            System.out.println("Error al manejar secrets");
            return Optional.empty();
        }
    }

    public String getWebHookToken() {
        return getSecretValue(secretWebHookToken).map(jsonNode -> jsonNode.get("WEBHOOK_TOKEN").asText()).orElse("");
    }


}
