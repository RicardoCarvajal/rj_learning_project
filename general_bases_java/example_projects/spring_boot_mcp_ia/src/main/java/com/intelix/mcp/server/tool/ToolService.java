package com.intelix.mcp.server.tool;

import com.intelix.mcp.server.config.ConfProperties;
import com.intelix.mcp.server.model.RequestData;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class ToolService {

    private final RestClient restClient;
    private final ConfProperties confProperties;

    public ToolService(RestClient restClient, ConfProperties confProperties) {
        this.restClient = restClient;
        this.confProperties = confProperties;
    }

    @Tool(name = "Enviar articulo", description = "Enviar articulos al sistema de BoPos de EPA")
    public String sendArticleBopos(
            @ToolParam(description = "Lista de codigos de articulos", required = true) List<Integer> codeArticle,
            @ToolParam(description = "Lista de numeros de tiendas", required = true) List<Integer> storeArticle
    ) {

        RequestData data = new RequestData();
        data.setArticles(codeArticle.stream().map(c -> {
            return Integer.toString(c);
        }).toList());
        data.setStores(storeArticle.stream().map(s -> {
            return Integer.toString(s);
        }).toList());

        ResponseEntity<String> response = restClient.post().uri(urlBuilder -> urlBuilder
                        .path(confProperties.getSendArticleUrl())
                        .build())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(data)
                .retrieve()
                .toEntity(String.class);

        return response.getBody();
    }

    @Tool(name = "Inactivar articulo", description = "Inactivar articulos en el sistema de BoPos de EPA")
    public String inactiveArticleBopos(
            @ToolParam(description = "Lista de codigos de articulos", required = true) List<Integer> codeArticle,
            @ToolParam(description = "Lista de numeros de tiendas", required = true) List<Integer> storeArticle
    ) {

        RequestData data = new RequestData();
        data.setArticles(codeArticle.stream().map(c -> {
            return Integer.toString(c);
        }).toList());
        data.setStores(storeArticle.stream().map(s -> {
            return Integer.toString(s);
        }).toList());

        ResponseEntity<String> response = restClient.post().uri(urlBuilder -> urlBuilder
                        .path(confProperties.getInactiveArticleUrl())
                        .build())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(data)
                .retrieve()
                .toEntity(String.class);

        return response.getBody();
    }

}