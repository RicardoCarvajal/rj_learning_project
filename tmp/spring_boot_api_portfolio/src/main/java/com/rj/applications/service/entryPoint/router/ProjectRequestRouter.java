package com.rj.applications.service.entryPoint.router;

import com.rj.applications.service.entryPoint.handler.ProjectRequestHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class ProjectRequestRouter {

    @Bean
    public RouterFunction<ServerResponse> getProjects(ProjectRequestHandler projectRequestHandler) {
        return RouterFunctions.route(RequestPredicates.GET("/api/projects"), projectRequestHandler::getAll);
    }

    @Bean
    RouterFunction<ServerResponse> createProject(ProjectRequestHandler projectRequestHandler) {
        return RouterFunctions.route(RequestPredicates.POST("/api/project"), projectRequestHandler::create);
    }

    @Bean
    RouterFunction<ServerResponse> getProject(ProjectRequestHandler projectRequestHandler) {
        return RouterFunctions.route(RequestPredicates.GET("/api/project/{id}"), projectRequestHandler::get);
    }

    @Bean
    RouterFunction<ServerResponse> delete(ProjectRequestHandler projectRequestHandler) {
        return RouterFunctions.route(RequestPredicates.DELETE("/api/project/delete/{id}"), projectRequestHandler::delete);
    }

}
