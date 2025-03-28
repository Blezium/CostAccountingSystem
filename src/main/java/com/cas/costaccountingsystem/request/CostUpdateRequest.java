package com.cas.costaccountingsystem.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CostUpdateRequest {
    private double price;

    private String currency;

    private String description;
}
