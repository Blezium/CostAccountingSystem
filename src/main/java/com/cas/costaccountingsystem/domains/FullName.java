package com.cas.costaccountingsystem.domains;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class FullName {
    private String firstName;
    private String lastName;
}
