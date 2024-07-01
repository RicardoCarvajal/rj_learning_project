package com.rj.applications.service.domain.mapper;

import com.rj.applications.service.drivenAdapter.entity.ProjectRequest;
import com.rj.applications.service.entryPoint.dto.ProjectRequestDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ProjectRequestMapper {

    @Mappings({
            @Mapping(source = "_id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "percentage", target = "percentage"),
            @Mapping(source = "deviationPercentage", target = "deviationPercentage"),
            @Mapping(source = "observations", target = "observations"),
            @Mapping(source = "requestDateInit", target = "requestDateInit"),
            @Mapping(source = "requestDateFinalPlan", target = "requestDateFinalPlan"),
            @Mapping(source = "requestDateFinalReal", target = "requestDateFinalReal"),
            @Mapping(source = "state", target = "state"),
            @Mapping(source = "area", target = "area")})
    public ProjectRequestDto toDto(ProjectRequest projectRequest);

    @InheritInverseConfiguration
    public ProjectRequest toEntity(ProjectRequestDto projectRequestDto);
}
