package com.rj.applications.service.entryPoint.handler;

import com.rj.applications.service.domain.useCase.CreateProjectRequestUseCase;
import com.rj.applications.service.domain.useCase.DeleteProjectRequestUseCase;
import com.rj.applications.service.domain.useCase.GetProjectRequestUseCase;
import com.rj.applications.service.domain.useCase.GetProjectsRequestsUseCase;
import com.rj.applications.service.entryPoint.dto.ProjectRequestDto;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class ProjectRequestHandler {

    private final GetProjectsRequestsUseCase getProjectsRequestsUseCase;

    private final GetProjectRequestUseCase getProjectRequestUseCase;

    private final CreateProjectRequestUseCase createProjectRequestUseCase;

    private final DeleteProjectRequestUseCase deleteProjectRequestUseCase;

    public ProjectRequestHandler(GetProjectsRequestsUseCase getProjectsRequestsUseCase, GetProjectRequestUseCase getProjectRequestUseCase, CreateProjectRequestUseCase createProjectRequestUseCase, DeleteProjectRequestUseCase deleteProjectRequestUseCase) {
        this.getProjectsRequestsUseCase = getProjectsRequestsUseCase;
        this.getProjectRequestUseCase = getProjectRequestUseCase;
        this.createProjectRequestUseCase = createProjectRequestUseCase;
        this.deleteProjectRequestUseCase = deleteProjectRequestUseCase;
    }

    public Mono<ServerResponse> get(ServerRequest request) {
        String id = request.pathVariable("id");
        return getProjectRequestUseCase.get(id).flatMap(project -> {
            return ServerResponse.ok().bodyValue(project);
        });
    }

    public Mono<ServerResponse> getAll(ServerRequest request) {
        return getProjectsRequestsUseCase.getAll().collectList().flatMap(list -> {
            System.out.println("Entregando listas");
            return ServerResponse.ok().bodyValue(list);
        });
    }

    public Mono<ServerResponse> create(ServerRequest request) {
        Mono<ProjectRequestDto> projectDtoMono = request.bodyToMono(ProjectRequestDto.class);
        return projectDtoMono.flatMap(projectDto -> {
            return createProjectRequestUseCase.create(projectDto).flatMap(id -> {
                return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(id);
            });
        });

    }

    public Mono<ServerResponse> delete(ServerRequest request) {
        String id = request.pathVariable("id");

        return deleteProjectRequestUseCase.delete(id).flatMap(idString -> {
            return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(idString);
        });
    }


}
