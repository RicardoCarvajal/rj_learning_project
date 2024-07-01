package com.rj.app.service.domain.services;

import com.rj.app.service.drivenAdapter.clientRest.ClientRestProject;
import com.rj.app.service.entryPoint.dto.ProjectRequestDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProjectService {

    private final ClientRestProject clientRestProject;


    public ProjectService(ClientRestProject clientRestProduct) {
        this.clientRestProject = clientRestProduct;
    }

    public Mono<ProjectRequestDto> getProject(String id){
        return clientRestProject.getProject(id);
    }

    public Flux<ProjectRequestDto> getProjects() {
        return clientRestProject.getProjects();
    }

    public Mono<String> saveProject(ProjectRequestDto projectRequestDto) {
        return clientRestProject.saveProject(projectRequestDto);
    }

    public  Mono<String> delete(String id){
        return clientRestProject.delete(id);
    }


}
