package com.intelix.mcp.server.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfProperties {

    private final ObjectMapper objectMapper;

    @Value("${aws.secretsmanager.url1}")
    private String secretCredential;

    @Value("${aws.secretsmanager.url2}")
    private String secretUser;

    public ConfProperties(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /*    private Optional<JsonNode> getSecretValue(String secretID) {
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
    */

    public String getSendArticleUrl() {
        return "/api/v1/article/send";
    }


    public String getInactiveArticleUrl() {
        return "/api/v1/article/inactivate";
    }


}