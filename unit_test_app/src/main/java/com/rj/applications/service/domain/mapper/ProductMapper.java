package com.rj.applications.service.domain.mapper;

import com.rj.applications.service.drivenAdapter.entity.Producto;
import com.rj.applications.service.entryPoint.dto.ProductDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mappings({@Mapping(source = "codigo", target = "code"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "descripcion", target = "description"),
            @Mapping(source = "existencia", target = "stock"),
            @Mapping(source = "percioDetal", target = "retailPrice"),
            @Mapping(source = "percioMayor", target = "mayorPrice")})
    ProductDto toDto(Producto producto);

    @InheritInverseConfiguration
    Producto fromDto(ProductDto product);
}
