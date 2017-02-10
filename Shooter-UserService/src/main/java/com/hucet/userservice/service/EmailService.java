package com.hucet.userservice.service;

import com.hucet.common.exception.server.MQBindingConfigException;
import com.hucet.rabbitmq.dto.MailCertDto;
import com.hucet.rabbitmq.properties.BindRabbitMQProperties;
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
public interface EmailService {
    void notifyEmailCert(RabbitTemplate rabbitTemplate, AccountDto dto);

    @Service
    @Transactional
    @Slf4j
    class Impl implements EmailService {

        @Autowired
        ModelMapper mapper;

        private BindRabbitMQProperties.BindingProperties emailProperty;

        @Autowired
        BindRabbitMQProperties bindRabbitMQProperties;


        BindRabbitMQProperties.BindingProperties getEmailProperty(BindRabbitMQProperties properties) {
            if (emailProperty == null) {
                String mailKey = "mail";
                if (properties.getBinding().containsKey(mailKey)) {
                    emailProperty = properties.getBinding().get(mailKey);
                } else {
                    throw new MQBindingConfigException("MQ Bind 설정 에러입니다.");
                }
            }
            return emailProperty;
        }


        @Override
        public void notifyEmailCert(RabbitTemplate rabbitTemplate, AccountDto dto) {
            MailCertDto mailCertDto = mapper.map(dto, MailCertDto.class);
            rabbitTemplate.setMessageConverter(jsonMessageConverter());
            rabbitTemplate.convertAndSend(getEmailProperty(bindRabbitMQProperties).getExchange(),
                    getEmailProperty(bindRabbitMQProperties).getRountingKey(),
                    mailCertDto);
        }

        @Bean
        public MessageConverter jsonMessageConverter() {
            return new Jackson2JsonMessageConverter();
        }
    }
}
