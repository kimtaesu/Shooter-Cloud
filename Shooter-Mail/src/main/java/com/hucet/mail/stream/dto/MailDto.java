package com.hucet.mail.stream.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@ToString
public class MailDto implements Serializable {
    @NotEmpty
    private String userName;
    @Email
    @NotEmpty
    private String userEmail;

    public MailDto(String taesu, String s) {
        userName = taesu;
        userEmail = s;
    }
}
