package com.hucet.rabbitmq.dto;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@ToString
public class OAuth2UserDto implements Serializable {
    @NotNull
    private String userName;

    @NotNull
    @Email
    private String userEmail;

    @NotNull
    private String password;
}
