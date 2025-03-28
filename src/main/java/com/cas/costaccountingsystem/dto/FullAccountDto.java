package com.cas.costaccountingsystem.dto;

import com.cas.costaccountingsystem.domains.AccountType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class FullAccountDto {
    private Long id;

    private String nickname;

    private FullNameDto fullName;

    private String password;

    private String email;

    private LocalDateTime initializedAt;

    private LocalDateTime updatedAt;

    private AccountType type;

    private List<ProjectDto> projects;
}
