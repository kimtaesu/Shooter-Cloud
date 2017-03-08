package com.hucet.shared.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(
        prefix = "shooter"
)
@Data
public class ShooterProperties {
    private Origin origin;
    private Register register;

    @Data
    public static class Origin {
        private boolean enable = true;
        private String host;
        private int port;
    }

    @Data
    public static class Register {
        private long frequency = 10;
    }
}
