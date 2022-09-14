package com.task.myApp.orderline;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A DTO for the {@link OrderLine} entity
 */
@Data
public class OrderLineDto implements Serializable {
    private final Integer id;
    private final Integer orderId;
    private final Integer productId;
    @NotNull
    private final Integer quantity;

}