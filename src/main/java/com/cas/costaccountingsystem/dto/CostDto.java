package com.cas.costaccountingsystem.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CostDto {
    private Long id;

    private double price;

    private String currency;

    private LocalDateTime initializedAt;

    private LocalDateTime updatedAt;

    private ProjectDto project;
}
