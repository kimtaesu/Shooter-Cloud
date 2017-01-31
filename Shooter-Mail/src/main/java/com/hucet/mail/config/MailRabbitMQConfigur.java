package com.hucet.mail.config;


import com.hucet.common.dto.MailCertDto;
import com.hucet.rabbitmq.binder.AbstractRabbitMQBindConfig;
import com.hucet.rabbitmq.properties.BindRabbitMQProperties;
import com.hucet.rabbitmq.properties.DecorBindRabbitMQProperties;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Slf4j
@Configuration
@EnableConfigurationProperties(BindRabbitMQProperties.class)
@Data
public class MailRabbitMQConfigur extends AbstractRabbitMQBindConfig<MailCertDto> {

    @Autowired
    DecorBindRabbitMQProperties decorBindRabbitMQProperties;

    @Override
    protected Queue queue() {
        return new Queue(decorBindRabbitMQProperties.getMailBinding().getQueue());
    }

    @Override
    protected Exchange exchange() {
        return new DirectExchange(decorBindRabbitMQProperties.getMailBinding().getExchange());
    }

    @Override
    protected Binding binding() {
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with(decorBindRabbitMQProperties.getMailBinding().getRountingKey())
                .noargs();
    }

    @Override
    public void onReceivedMessage(MailCertDto dto) {
        log.info(dto.toString());
    }
}
