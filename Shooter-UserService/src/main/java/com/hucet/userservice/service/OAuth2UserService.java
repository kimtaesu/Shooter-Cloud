package com.hucet.userservice.service;

import com.hucet.rabbitmq.dto.OAuth2UserDto;
import com.hucet.rabbitmq.properties.BindRabbitMQProperties;
import com.hucet.rabbitmq.properties.DecorBindRabbitMQProperties;
import com.hucet.userservice.dto.AccountDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by taesu on 2017-01-31.
 */
public interface OAuth2UserService {
    void notifyOAuthUserAdded(AccountDto.ApplicationRequest dto, RabbitTemplate rabbitTemplate);

    @Service
    @Transactional
    @Slf4j
    class Impl implements OAuth2UserService {
        @Autowired
        DecorBindRabbitMQProperties decorBindRabbitMQProperties;

        @Autowired
        ModelMapper mapper;

        @Override
        public void notifyOAuthUserAdded(AccountDto.ApplicationRequest dto, RabbitTemplate rabbitTemplate) {
            BindRabbitMQProperties.BindingProperties bindingProperties = decorBindRabbitMQProperties.getOAuthBinding();
            if (bindingProperties != null) {
                OAuth2UserDto auth2UserDto = mapper.map(dto, OAuth2UserDto.class);
                rabbitTemplate.setMessageConverter(jsonMessageConverter());
                rabbitTemplate.convertAndSend(bindingProperties.getExchange(),
                        bindingProperties.getRountingKey(),
                        auth2UserDto);
            } else {
                throw new RuntimeException("can't not inject a oauth of binding key");
            }
        }

        @Bean
        public MessageConverter jsonMessageConverter() {
            return new Jackson2JsonMessageConverter();
        }
    }
}
