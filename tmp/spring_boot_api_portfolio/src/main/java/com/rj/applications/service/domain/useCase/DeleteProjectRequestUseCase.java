package com.rj.applications.service.domain.useCase;

import com.rj.applications.service.drivenAdapter.repository.IProjectRequestRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeleteProjectRequestUseCase {

    private final IProjectRequestRepository projectRequestRepository;


    public DeleteProjectRequestUseCase(IProjectRequestRepository projectRequestRepository) {
        this.projectRequestRepository = projectRequestRepository;
    }

    public Mono<String> delete(String id) {
        return projectRequestRepository.deleteById(id).flatMap(pd -> {
            return Mono.just(id);
        });
    }
}
