package com.task.myApp.customer;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link Customer} entity
 */
@Data
public class CustomerDto implements Serializable {
    private final Integer id;
    @NotNull
    private final Integer registrationCode;
    @Size(max = 100)
    @NotNull
    private final String firstName;
    @Size(max = 100)
    @NotNull
    private final String lastName;
    @Size(max = 50)
    @NotNull
    private final String telephone;
    @Size(max = 320)
    @NotNull
    private final String email;
}