package com.task.myApp.product;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link Product} entity
 */
@Data
public class ProductDto implements Serializable {
    private final Integer id;
    @Size(max = 255)
    @NotNull
    private final String name;
    @Size(max = 50)
    @NotNull
    private final String skuCode;
    @NotNull
    private final BigDecimal unitPrice;
}