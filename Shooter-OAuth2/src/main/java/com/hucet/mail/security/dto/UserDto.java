package com.hucet.mail.security.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

public class UserDto {
    @Data
    @NoArgsConstructor
    @ToString
    public static abstract class BasicUserDto implements Serializable {
        @NotEmpty
        private String password;
        @Email
        @NotEmpty
        private String userEmail;
    }

    @Data
    @NoArgsConstructor
    @ToString
    public static class JoinDto extends BasicUserDto {
        @NotEmpty
        private String userName;
    }

    @Data
    @NoArgsConstructor
    @ToString
    public static class LoginDto extends BasicUserDto {
    }
}
