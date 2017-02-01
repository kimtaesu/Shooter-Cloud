package com.hucet.oauth2.config;


import com.hucet.oauth2.service.OAuthUserService;
import com.hucet.rabbitmq.binder.AbstractRabbitMQBindConfig;
import com.hucet.rabbitmq.dto.OAuth2UserDto;
import com.hucet.rabbitmq.properties.DecorBindRabbitMQProperties;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


@Slf4j
@Configuration
@Data
public class OAuthRabbitMQConfigur extends AbstractRabbitMQBindConfig<OAuth2UserDto> {

    @Autowired
    DecorBindRabbitMQProperties decorBindRabbitMQProperties;

    @Autowired
    OAuthUserService oAuthUserService;

    @Override
    protected Queue queue() {
        return new Queue(decorBindRabbitMQProperties.getOAuthBinding().getQueue());
    }

    @Override
    protected Exchange exchange() {
        return new DirectExchange(decorBindRabbitMQProperties.getOAuthBinding().getExchange());
    }

    @Override
    protected Binding binding() {
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with(decorBindRabbitMQProperties.getOAuthBinding().getRountingKey())
                .noargs();
    }

    @Override
    public void onReceivedMessage(OAuth2UserDto dto) {
        oAuthUserService.addOAuth2User(dto);
    }
}
