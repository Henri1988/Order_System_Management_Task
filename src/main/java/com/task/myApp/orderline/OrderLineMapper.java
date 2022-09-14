package com.task.myApp.orderline;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OrderLineMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "orderId", target = "order.id")
    @Mapping(source = "productId", target = "product.id")
    OrderLine toEntity(OrderLineDto orderLineDto);

    @InheritInverseConfiguration(name = "toEntity")
    OrderLineDto toDto(OrderLine orderLine);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    OrderLine updateEntity(OrderLineDto orderLineDto, @MappingTarget OrderLine orderLine);
}
