package com.hucet.oauth2.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class OAuthAccountDto {
    @NotNull
    private String userName;

    @NotNull
    private String password;
}
