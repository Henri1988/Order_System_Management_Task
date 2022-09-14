package com.task.myApp.order;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link Order} entity
 */
@Data
public class OrderDto implements Serializable {
    private final Integer id;
    @NotNull
    private final LocalDate orderDate;
    private final Integer customerId;

}