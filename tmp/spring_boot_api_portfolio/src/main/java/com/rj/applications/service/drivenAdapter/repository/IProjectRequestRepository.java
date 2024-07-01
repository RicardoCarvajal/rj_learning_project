package com.rj.applications.service.drivenAdapter.repository;

import com.rj.applications.service.drivenAdapter.entity.ProjectRequest;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IProjectRequestRepository extends ReactiveMongoRepository<ProjectRequest, String> {

}
