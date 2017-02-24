package com.hucet.mail.stream.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Getter
@NoArgsConstructor
@ToString
public class MailDto {
    @NotEmpty
    private String userName;
    @Email
    @NotEmpty
    private String userEmail;
}
