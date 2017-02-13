package com.hucet.userservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@ToString
public class AccountDto implements Serializable{
    @NotEmpty
    private String userName;
    @NotEmpty
    private String password;
    @Email
    @NotEmpty
    private String userEmail;
}
