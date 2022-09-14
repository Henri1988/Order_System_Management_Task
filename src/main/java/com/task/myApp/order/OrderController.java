package com.task.myApp.order;

import com.task.myApp.infrastructure.exception.BusinessException;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;


@RestController
public class OrderController {
    final int DEFAULT_LIMIT = 128;
    @Resource
    private OrderService orderService;


    @PostMapping("/order/create")
    @Operation(summary = "Creates new order")
    public OrderDto addNewOrder (@RequestBody OrderDto orderDto){
        return orderService.addNewOrder(orderDto);
    }

    @GetMapping("/order/search/by/date")
    @Operation(summary = "Finds all orders by date")
    public List<OrderDto> findOrdersByDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @Nullable Integer limit, @Nullable Integer offset){
        return orderService.findOrdersByDate(date, validateLimit(limit), validateOffset(offset));
    }

    @GetMapping("/order/search/by/customer")
    @Operation(summary = "Finds all orders by customer id")
    public List <OrderDto>findOrdersByCustomerId(@RequestParam int customer_id){
        return orderService.findOrdersByCustomerId(customer_id);
    }

    @GetMapping("/order/search/by/product")
    @Operation(summary = "Finds all orders by product id")
    public List <OrderDto>findOrdersByProductId(@RequestParam int product_id){
        return orderService.findOrdersByProductId(product_id);
    }

    private int validateLimit(Integer limit) {
        if (limit == null || limit == 0) {
            return DEFAULT_LIMIT;
        }

        if (limit < 0) {
            throw  new BusinessException("Invalid limit.", "Limit is too small " + limit + ".");
        }

        if (limit > 1000) {
            throw  new BusinessException("Invalid limit.", "Limit is too high " + limit + ".");
        }

        return limit;
    }

    private int validateOffset(Integer offset) {
        if (offset == null) {
            return 0;
        }

        if (offset < 0) {
            throw  new BusinessException("Invalid offset.", "Offset is too small " + offset + ".");
        }

        return offset;
    }

}
