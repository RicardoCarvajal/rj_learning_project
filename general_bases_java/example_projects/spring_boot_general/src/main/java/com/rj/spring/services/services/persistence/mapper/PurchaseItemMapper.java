package com.rj.spring.services.services.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.rj.spring.services.services.domain.PurchaseItem;
import com.rj.spring.services.services.persistence.entity.CompraProducto;

@Mapper(componentModel = "spring", uses = { ProductMapper.class })
public interface PurchaseItemMapper {

	@Mappings({ @Mapping(source = "id.idProducto", target = "productId"),
			@Mapping(source = "cantidad", target = "quantity"), @Mapping(source = "estado", target = "active") })
	PurchaseItem toPurchaseItem(CompraProducto compraProducto);

	@InheritInverseConfiguration
	@Mappings({ @Mapping(target = "producto", ignore = true), @Mapping(target = "compra", ignore = true),
			@Mapping(target = "id.idCompra", ignore = true) })
	CompraProducto toCompraProducto(PurchaseItem purchaseItem);

}
