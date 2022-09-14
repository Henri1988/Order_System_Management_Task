package com.task.myApp.orderline;

import com.task.myApp.infrastructure.exception.NotFoundException;
import com.task.myApp.order.Order;
import com.task.myApp.order.OrderRepository;
import com.task.myApp.product.Product;
import com.task.myApp.product.ProductRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class OrderLineService {
    @Resource
    private OrderRepository orderRepository;
    @Resource
    private ProductRepository productRepository;
    @Resource
    private OrderLineRepository orderLineRepository;
    @Resource
    private OrderLineMapper orderLineMapper;


    public OrderLineDto addNewOrderLine(OrderLineDto orderLineDto) {
        OrderLine orderLine = orderLineMapper.toEntity(orderLineDto);
        Optional<Order> order = orderRepository.findById(orderLineDto.getOrderId());
        if (order.isEmpty()) {
            throw new NotFoundException("Invalid order", "Order not found");
        }
        orderLine.setOrder(order.get());

        Optional<Product> product = productRepository.findById(orderLineDto.getProductId());
        if (product.isEmpty()) {
            throw new NotFoundException("Invalid product", "Product not found");
        }
        orderLine.setProduct(product.get());
        orderLineRepository.save(orderLine);
        return orderLineMapper.toDto(orderLine);
    }

    public void updateOrderLineById(OrderLineDto orderLineDto, Integer orderLineId) {
        OrderLine orderLine = orderLineRepository.getReferenceById(orderLineId);
        orderLineMapper.updateEntity(orderLineDto,orderLine);
        orderLineRepository.save(orderLine);
    }
}
