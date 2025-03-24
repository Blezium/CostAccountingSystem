package com.cas.costaccountingsystem.request;

import com.cas.costaccountingsystem.domains.AccountType;
import com.cas.costaccountingsystem.dto.FullNameDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class AccountCreationRequest {
    private String nickname;

    private FullNameDto fullName;

    private String password;

    private String email;

    private LocalDateTime initializedAt;

    private LocalDateTime updatedAt;

    private AccountType type;

    private List<Long> projectsIds;
}
