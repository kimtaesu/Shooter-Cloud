package com.hucet.mail.config.rabbitmq;


import com.hucet.mail.service.MailSendService;
import com.hucet.mail.type.EmailType;
import com.hucet.rabbitmq.binder.AbstractRabbitMQBindConfig;
import com.hucet.rabbitmq.dto.MailCertDto;
import com.hucet.rabbitmq.properties.BindRabbitMQProperties;
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
public class MailRabbitMQConfigur extends AbstractRabbitMQBindConfig<MailCertDto, Void> {

    private BindRabbitMQProperties.BindingProperties mailProperty;

    @Autowired
    MailSendService mailSendService;
    BindRabbitMQProperties.BindingProperties getMailProperty(BindRabbitMQProperties properties) {
        if (mailProperty == null) {
            String mailKey = "mail";
            if (properties.getBinding().containsKey(mailKey)) {
                mailProperty = properties.getBinding().get(mailKey);
            }
        }
        return mailProperty;
    }

    @Override
    protected Queue queue() {
        return new Queue(getMailProperty(getBindRabbitMQProperties()).getQueue());
    }

    @Override
    protected Exchange exchange() {
        return new DirectExchange(getMailProperty(getBindRabbitMQProperties()).getExchange());
    }

    @Override
    protected Binding binding() {
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with(getMailProperty(getBindRabbitMQProperties()).getRountingKey())
                .noargs();
    }

    @Override
    public Void handleMessage(MailCertDto dto) {
        mailSendService.mailSend(EmailType.EMAIL_CERT, dto);
        return null;
    }
}
