package com.cas.costaccountingsystem.request;

import com.cas.costaccountingsystem.domains.AccountType;
import com.cas.costaccountingsystem.dto.FullNameDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
public class AccountUpdateRequest {
    @NotEmpty(message = "Nickname can not be empty")
    private String nickname;

    private FullNameDto fullName;

    @Min(value = 8, message = "Password must contain at least 8 characters long")
    @Max(value = 16, message = "Password must be no more than 16 characters long")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]$"
            , message = "Password must have at least 1 lowercase, 1 uppercase letter, 1 special character and " +
            "1 number")
    private String password;

    @Pattern(regexp = ".+@knu\\.ua$", message = "Email must end with @knu.ua")
    private String email;

    private LocalDateTime initializedAt;

    private LocalDateTime updatedAt;

    private AccountType type;

    private List<Long> projectsIds;
}
