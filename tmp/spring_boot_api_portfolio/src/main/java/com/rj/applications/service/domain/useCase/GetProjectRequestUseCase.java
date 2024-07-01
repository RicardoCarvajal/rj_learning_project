package com.rj.applications.service.domain.useCase;

import com.rj.applications.service.domain.mapper.ProjectRequestMapper;
import com.rj.applications.service.drivenAdapter.repository.IProjectRequestRepository;
import com.rj.applications.service.entryPoint.dto.ProjectRequestDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class GetProjectRequestUseCase {

    private final IProjectRequestRepository projectRequestRepository;

    private final ProjectRequestMapper projectRequestMapper;

    public GetProjectRequestUseCase(IProjectRequestRepository projectRequestRepository, ProjectRequestMapper projectRequestMapper) {
        this.projectRequestRepository = projectRequestRepository;
        this.projectRequestMapper = projectRequestMapper;
    }

    public Mono<ProjectRequestDto> get(String id) {
        return projectRequestRepository.findById(id).map(projectRequestMapper::toDto);
    }
}
