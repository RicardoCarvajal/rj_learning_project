package com.rcarvajal.app.service.conf;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class ConfProperties {

    private final ObjectMapper objectMapper;

    @Value("${aws.secretsmanager.secretcredential}")
    private String secretCredential;

    @Value("${aws.secretsmanager.secretuser}")
    private String secretUser;

    public ConfProperties(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public JsonNode getSecretValue(String secretID) {
        try {
            SecretsManagerClient secretsClient = SecretsManagerClient.builder()
                    .region(Region.US_WEST_2)
                    .build();

            GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder()
                    .secretId(secretID)
                    .build();

            GetSecretValueResponse getSecretValueResponse = secretsClient.getSecretValue(getSecretValueRequest);

            secretsClient.close();

            return objectMapper.readTree(getSecretValueResponse.secretString());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al manejar secrets");
            return objectMapper.nullNode();
        }
    }

    public String getCredentialTelegram() {
        try {
            return getSecretValue(secretCredential).get("TELEGRAM_TOKEN").asText();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al extraer el token de TELEGRAM");
            return "";
        }
    }

    public List<String> getUsers() {
        try {
            return Arrays.stream(getSecretValue(secretUser).get("TELEGRAM_USERS").asText().split(",")).toList();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al extraer el usuarios de TELEGRAM");
            return new ArrayList<>();
        }
    }


}
