package com.hucet.userservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Getter
@NoArgsConstructor
public class AccountDto {
    @NotEmpty
    private String userName;
    @NotEmpty
    private String password;
    @Email
    @NotEmpty
    private String userEmail;
}
