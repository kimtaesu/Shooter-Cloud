package com.hucet.mail.properties;

import com.sun.istack.internal.NotNull;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by taesu on 2017-01-26.
 */
@Component
@Data
@EnableConfigurationProperties(MailConfProperties.class)
@ConfigurationProperties(prefix = "mail")
public class MailConfProperties {
    @Data
    public static class Smtp {
        private Boolean auth;
        private Boolean startTlsRequired;
        private Boolean startTlsEnable;
    }
    private Boolean enable = true;
    private String host;
    private String protocol;
    private int port;
    private String email;
    private String password;
    private String defaultEncoding;
    private String debug;
    @NotNull
    private Smtp smtp;
}
