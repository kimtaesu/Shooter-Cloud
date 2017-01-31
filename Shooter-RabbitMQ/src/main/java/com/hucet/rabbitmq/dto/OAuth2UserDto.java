package com.hucet.common.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@ToString
public class OAuth2UserDto {
    @NotNull
    private String userName;
    @NotNull
    private String password;
}
