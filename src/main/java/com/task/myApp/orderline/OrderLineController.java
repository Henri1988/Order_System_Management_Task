package com.task.myApp.orderline;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class OrderLineController {
    @Resource
    private OrderLineService orderLineService;


    @PostMapping("/orderline/create")
    @Operation(summary = "Adds new order line")
    public OrderLineDto addNewOrderLine (@RequestBody OrderLineDto orderLineDto){
        return orderLineService.addNewOrderLine(orderLineDto);
    }

    @PutMapping("/orderline/update")
    @Operation(summary = "Updates orderline product quantity")
    public void updateOrderLineById(@RequestBody OrderLineDto orderLineDto, @RequestParam Integer orderLineId){
        orderLineService.updateOrderLineById(orderLineDto,orderLineId);
    }

}
