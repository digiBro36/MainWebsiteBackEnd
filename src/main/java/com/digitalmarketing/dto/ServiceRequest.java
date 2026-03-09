package com.digitalmarketing.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ServiceRequest {
    @NotBlank
    private String title;

    private String description;

    @NotNull
    private Double price;

    @NotNull
    private Boolean active;
}
