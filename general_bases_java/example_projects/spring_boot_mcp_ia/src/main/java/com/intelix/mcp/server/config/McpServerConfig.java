package com.intelix.mcp.server.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intelix.mcp.server.tool.ToolService;
import io.modelcontextprotocol.server.McpAsyncServer;
import io.modelcontextprotocol.server.McpServer;
import io.modelcontextprotocol.server.transport.WebFluxSseServerTransportProvider;
import io.modelcontextprotocol.spec.McpSchema;
import org.springframework.ai.mcp.McpToolUtils;
import org.springframework.ai.tool.ToolCallbacks;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.server.RouterFunction;

@Configuration
public class McpServerConfig {

    @Bean
    public WebFluxSseServerTransportProvider sseServerTransportProvider() {
        return new WebFluxSseServerTransportProvider(new ObjectMapper(), "/mcp/message");
    }

    @Bean
    public RouterFunction<?> mcpRouterFunction(WebFluxSseServerTransportProvider transportProvider) {
        return transportProvider.getRouterFunction();
    }


    @Bean
    public ToolService toolService(RestClient restClient, ConfProperties confProperties) {
        return new ToolService(restClient, confProperties);
    }

    @Bean
    public McpAsyncServer mcpServer(WebFluxSseServerTransportProvider sseServerTransportProvider, ToolService toolService) {

        // Configure server capabilities with resource support
        var capabilities = McpSchema.ServerCapabilities.builder()
                .tools(true)
                .logging()
                .build();

        return McpServer.async(sseServerTransportProvider)
                .capabilities(capabilities)
                .tools(McpToolUtils.toAsyncToolSpecifications(ToolCallbacks.from(toolService)))
                .build();
    }

}