package com.hucet.userservice.service;

import com.hucet.module.properties.BindForMailProperties;
import com.hucet.userservice.dto.AccountDto;
import com.hucet.userservice.dto.MailCertDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by taesu on 2017-01-31.
 */
public interface EmailService {
    void notifyEmailCert(AccountDto.ApplicationRequest dto);

    @Transactional
    @EnableConfigurationProperties(BindForMailProperties.class)
    @Slf4j
    class Impl implements EmailService {
        @Autowired
        BindForMailProperties bindForMailProperties;

        @Autowired
        private RabbitTemplate rabbitTemplate;

        @Autowired
        ModelMapper mapper;

        @Override
        public void notifyEmailCert(AccountDto.ApplicationRequest dto) {
            MailCertDto mailCertDto = mapper.map(dto, MailCertDto.class);
            rabbitTemplate.setMessageConverter(jsonMessageConverter());
            rabbitTemplate.convertAndSend(bindForMailProperties.getExchange(),
                    bindForMailProperties.getRountingKey(),
                    mailCertDto);
        }

        @Bean
        public MessageConverter jsonMessageConverter() {
            return new Jackson2JsonMessageConverter();
        }
    }
}
