package com.hucet.oauth2.config.rabbitmq;


import com.hucet.oauth2.service.OAuthUserService;
import com.hucet.rabbitmq.binder.AbstractRabbitMQBindConfig;
import com.hucet.rabbitmq.dto.OAuth2UserDto;
import com.hucet.rabbitmq.properties.BindRabbitMQProperties;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Slf4j
@Configuration
@Data
@EnableConfigurationProperties(BindRabbitMQProperties.class)
public class OAuthRabbitMQConfigur extends AbstractRabbitMQBindConfig<OAuth2UserDto> {

    private BindRabbitMQProperties.BindingProperties oauthProperty;

    BindRabbitMQProperties.BindingProperties getOAuthProperty(BindRabbitMQProperties properties) {
        if (oauthProperty == null) {
            String oauthKey = "oauth";
            if (properties.getBinding().containsKey(oauthKey)) {
                oauthProperty = properties.getBinding().get(oauthKey);
            }
        }
        return oauthProperty;
    }

    @Override
    protected Queue queue() {
        return new Queue(getOAuthProperty(getBindRabbitMQProperties()).getQueue());
    }

    @Override
    protected Exchange exchange() {
        return new DirectExchange(getOAuthProperty(getBindRabbitMQProperties()).getExchange());
    }

    @Override
    protected Binding binding() {
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with(getOAuthProperty(getBindRabbitMQProperties()).getRountingKey())
                .noargs();
    }

    @Autowired
    OAuthUserService oAuthUserService;

    @Override
    public void handleMessage(OAuth2UserDto dto) {
        oAuthUserService.addOAuth2User(dto);
    }
}
