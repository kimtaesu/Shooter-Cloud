package com.hucet.rabbitmq.dto;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@ToString
public class MailCertDto implements Serializable{
    @Email
    @NotNull
    private String userEmail;
    @NotNull
    private String userName;
}
