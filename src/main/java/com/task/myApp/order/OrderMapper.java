package com.task.myApp.order;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OrderMapper {

    @Mapping(source = "customerId", target = "customer.id")
    @Mapping(target = "id", ignore = true)
    Order toEntity(OrderDto orderDto);

    @InheritInverseConfiguration(name = "toEntity")
    OrderDto toDto(Order order);

    List<OrderDto> toDtos(List<Order> order);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Order updateEntity(OrderDto orderDto, @MappingTarget Order order);

}
