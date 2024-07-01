package com.rj.app.service.drivenAdapter.clientRest;

import com.rj.app.service.entryPoint.dto.ProjectRequestDto;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ClientRestProject {

    public Mono<ProjectRequestDto> getProject(String id){
        WebClient client = WebClient.create("http://localhost:8080");

        return client.get()
                .uri("/api/project/"+id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(ProjectRequestDto.class);
    }

    public Flux<ProjectRequestDto> getProjects(){
        WebClient client = WebClient.create("http://localhost:8080");

        return client.get()
                        .uri("/api/projects")
                        .accept(MediaType.APPLICATION_JSON)
                        .retrieve().bodyToFlux(ProjectRequestDto.class);
    }

    public Mono<String> saveProject(ProjectRequestDto project){
        WebClient client = WebClient.create("http://localhost:8080");

        return client.post()
                .uri("/api/project")
                .body(Mono.just(project),ProjectRequestDto.class)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve().bodyToMono(String.class);
    }

    public Mono<String> delete(String id){
        WebClient client = WebClient.create("http://localhost:8080");

        return client.delete()
                .uri("/api/project/delete/"+id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class);
    }

}
