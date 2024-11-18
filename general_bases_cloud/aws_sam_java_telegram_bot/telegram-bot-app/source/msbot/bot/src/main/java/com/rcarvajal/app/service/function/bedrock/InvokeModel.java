package com.rcarvajal.app.service.function.bedrock;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.json.JSONPointer;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.bedrockruntime.BedrockRuntimeClient;

@Slf4j
@Component
public class InvokeModel {

    public String generateResponse(String prompt) {

        var client = BedrockRuntimeClient.builder()
                .credentialsProvider(DefaultCredentialsProvider.create())
                .region(Region.US_WEST_2)
                .build();

        var modelId = "amazon.titan-text-lite-v1";

        var nativeRequestTemplate = "{ \"inputText\": \"{{prompt}}\" }";

        String nativeRequest = nativeRequestTemplate.replace("{{prompt}}", prompt);

        try {
            var response = client.invokeModel(request -> request
                    .body(SdkBytes.fromUtf8String(nativeRequest))
                    .modelId(modelId)
            );

            var responseBody = new JSONObject(response.body().asUtf8String());

            String text = new JSONPointer("/results/0/outputText").queryFrom(responseBody).toString();
            log.info(text);

            return text;

        } catch (SdkClientException e) {
            log.error("ERROR: Can't invoke {}. Reason: {}", modelId, e.getMessage());
            throw new RuntimeException(e);
        }
    }


}