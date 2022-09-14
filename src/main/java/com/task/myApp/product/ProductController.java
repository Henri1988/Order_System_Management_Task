package com.task.myApp.product;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ProductController {

    @Resource
    private ProductService productService;


    @PostMapping("/product/create")
    @Operation(summary = "Creates new product")
    public ProductDto addNewProduct(@RequestBody ProductDto productDto){
        return productService.addNewProduct(productDto);
    }
}
