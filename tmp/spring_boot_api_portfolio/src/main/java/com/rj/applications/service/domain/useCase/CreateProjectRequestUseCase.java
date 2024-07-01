package com.rj.applications.service.domain.useCase;

import com.rj.applications.service.domain.mapper.ProjectRequestMapper;
import com.rj.applications.service.drivenAdapter.entity.ProjectRequest;
import com.rj.applications.service.drivenAdapter.repository.IProjectRequestRepository;
import com.rj.applications.service.entryPoint.dto.ProjectRequestDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
public class CreateProjectRequestUseCase {

    private final IProjectRequestRepository projectRequestRepository;


    private final ProjectRequestMapper projectRequestMapper;

    public CreateProjectRequestUseCase(IProjectRequestRepository projectRequestRepository, ProjectRequestMapper projectRequestMapper) {
        this.projectRequestRepository = projectRequestRepository;
        this.projectRequestMapper = projectRequestMapper;
    }

    public Mono<String> create(ProjectRequestDto projectRequestDto) {
        projectRequestDto.setRequestDateInit(new Date());
        projectRequestDto.setRequestDateFinalReal(projectRequestDto.getRequestDateFinalPlan());
        projectRequestDto.setState("INICIADO");

        return this.projectRequestRepository.save(projectRequestMapper.toEntity(projectRequestDto)).map(ProjectRequest::get_id);
    }

}
