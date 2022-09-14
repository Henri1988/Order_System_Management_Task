package com.task.myApp.order;

import com.task.myApp.customer.Customer;
import com.task.myApp.customer.CustomerRepository;
import com.task.myApp.infrastructure.exception.NotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private CustomerRepository customerRepository;
    @Resource
    private OrderRepository orderRepository;

    public OrderDto addNewOrder(OrderDto orderDto) {
        Order order = orderMapper.toEntity(orderDto);
        System.out.println(orderDto);
        Optional<Customer> customer = customerRepository.findById(orderDto.getCustomerId());
        if (customer.isEmpty()) {
            throw new NotFoundException("Invalid customer", "Customer not found");
        }
        order.setCustomer(customer.get());
        orderRepository.save(order);
        return orderMapper.toDto(order);
    }

    public List<OrderDto> findOrdersByDate(LocalDate date, int limit, int offset) {
        System.out.println(limit);
        System.out.println(offset);
        List<Order> ordersByDate = orderRepository.findOrdersByDate(date, limit, offset);
        return orderMapper.toDtos(ordersByDate);
    }

    public List<OrderDto> findOrdersByCustomerId(int id) {
        List<Order> ordersByCustomerId = orderRepository.findOrdersByCustomerId(id);
        return orderMapper.toDtos(ordersByCustomerId);
    }

    public List<OrderDto> findOrdersByProductId(int id) {
        List<Order> ordersByProductId = orderRepository.findOrdersByProductId(id);
        return orderMapper.toDtos(ordersByProductId);
    }
}