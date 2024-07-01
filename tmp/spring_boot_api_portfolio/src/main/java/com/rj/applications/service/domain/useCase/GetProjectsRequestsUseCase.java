package com.rj.applications.service.domain.useCase;

import com.rj.applications.service.domain.mapper.ProjectRequestMapper;
import com.rj.applications.service.drivenAdapter.repository.IProjectRequestRepository;
import com.rj.applications.service.entryPoint.dto.ProjectRequestDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetProjectsRequestsUseCase {

    private final IProjectRequestRepository projectRequestRepository;

    private final ProjectRequestMapper projectRequestMapper;

    public GetProjectsRequestsUseCase(IProjectRequestRepository projectRequestRepository, ProjectRequestMapper projectRequestMapper) {
        this.projectRequestRepository = projectRequestRepository;
        this.projectRequestMapper = projectRequestMapper;
    }

    public Flux<ProjectRequestDto> getAll() {
        return projectRequestRepository.findAll().map(projectRequestMapper::toDto);
    }

}
