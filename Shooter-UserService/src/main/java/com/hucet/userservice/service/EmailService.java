package com.hucet.userservice.service;

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
    void notifyEmailCert(AccountDto dto, RabbitTemplate rabbitTemplate);

    @Service
    @Transactional
    @Slf4j
    class Impl implements EmailService {

        @Autowired
        ModelMapper mapper;

        @Override
        public void notifyEmailCert(AccountDto dto, RabbitTemplate rabbitTemplate) {
//            BindRabbitMQProperties.BindingProperties bindingProperties = decorBindRabbitMQProperties.getMailBinding();
//            if (bindingProperties != null) {
//                MailCertDto mailCertDto = mapper.map(dto, MailCertDto.class);
//                rabbitTemplate.setMessageConverter(jsonMessageConverter());
//                rabbitTemplate.convertAndSend(bindingProperties.getExchange(),
//                        bindingProperties.getRountingKey(),
//                        mailCertDto);
//            } else {
//                throw new RuntimeException("can't not inject a mail of binding key");
//            }

        }

        @Bean
        public MessageConverter jsonMessageConverter() {
            return new Jackson2JsonMessageConverter();
        }
    }
}
