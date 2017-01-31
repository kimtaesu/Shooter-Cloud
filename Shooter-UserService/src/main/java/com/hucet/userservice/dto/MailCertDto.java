package com.hucet.userservice.dto;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;

@Data
@ToString
public class MailCertDto {
    @Email
    @NotNull
    private String userEmail;
    @NotNull
    private String userName;
}
