package com.task.myApp.product;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductService {
    @Resource
    private ProductMapper productMapper;
    @Resource
    private ProductRepository productRepository;


    public ProductDto addNewProduct(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        productRepository.save(product);
        return productMapper.toDto(product);
    }

}