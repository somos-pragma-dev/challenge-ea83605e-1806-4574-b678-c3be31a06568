package com.fintech.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductDTO(
        Long id,
        @NotBlank String name,
        @NotNull @Min(0) Double price,
        @NotNull Integer stock,
        @NotBlank String category
) {}