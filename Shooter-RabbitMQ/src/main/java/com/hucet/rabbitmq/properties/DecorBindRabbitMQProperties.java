package com.hucet.rabbitmq.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Component
public class DecorBindRabbitMQProperties {

    @Autowired
    BindRabbitMQProperties properties;

    private final String mailKey = "mail";
    private final String oAuthKey = "oauth";

    public BindRabbitMQProperties.BindingProperties getMailBinding() {
        if (properties.getBinding().containsKey(mailKey)) {
            return properties.getBinding().get(mailKey);
        } else {
            return null;
        }
    }

    public BindRabbitMQProperties.BindingProperties getOAuthBinding() {
        if (properties.getBinding().containsKey(oAuthKey)) {
            return properties.getBinding().get(oAuthKey);
        } else {
            return null;
        }
    }
}
