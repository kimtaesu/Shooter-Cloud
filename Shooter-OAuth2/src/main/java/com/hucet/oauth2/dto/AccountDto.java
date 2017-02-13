package com.hucet.oauth2.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Getter
@NoArgsConstructor
@ToString
public class AccountDto {
    @NotEmpty
    private String userName;
    @NotEmpty
    private String password;
    @Email
    @NotEmpty
    private String userEmail;
}
