package com.cas.costaccountingsystem.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class FullNameDto {
    @NotEmpty(message = "First name must not be empty")
    private String firstName;

    @NotEmpty(message = "Last name must not be empty")
    private String lastName;
}
