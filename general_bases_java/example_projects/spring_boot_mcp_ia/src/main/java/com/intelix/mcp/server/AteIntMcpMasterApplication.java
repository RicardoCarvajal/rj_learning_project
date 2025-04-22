package com.intelix.mcp.server;

import com.intelix.mcp.server.tool.ToolService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AteIntMcpMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(AteIntMcpMasterApplication.class, args);
    }

    @Bean
    public ToolCallbackProvider weatherTools(ToolService toolService) {
        return MethodToolCallbackProvider.builder().toolObjects(toolService).build();
    }

}
