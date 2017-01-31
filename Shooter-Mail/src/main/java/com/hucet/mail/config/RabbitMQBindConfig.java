package com.hucet.mail.config;


import com.hucet.mail.listener.MQListener;
import com.hucet.module.properties.BindForMailProperties;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Slf4j
@Configuration
@EnableConfigurationProperties(BindForMailProperties.class)
@Data
public class RabbitMQBindConfig {

    @Autowired
    BindForMailProperties bindForMailProperties;

    @Autowired
    ConnectionFactory connectionFactory;

    @Bean
    Queue queue() {
        return new Queue(bindForMailProperties.getQueue());
    }

    @Bean
    Exchange directExchange() {
        return new DirectExchange(bindForMailProperties.getExchange());
    }

    @Bean
    Binding binding() {
        return BindingBuilder
                .bind(queue())
                .to(directExchange())
                .with(bindForMailProperties.getRountingKey())
                .noargs();
    }

    @Bean
    @Autowired
    MessageListenerAdapter mailSenderListener(MQListener.MQListenerImpl Listener) {
        MessageListenerAdapter adapter = new MessageListenerAdapter(Listener,
                "onReceiveredMailForCert");
        adapter.setMessageConverter(jsonMessageConverter());
        return adapter;
    }

    @Bean
    SimpleMessageListenerContainer mssageListenerContainer(Queue queue, MessageListenerAdapter adapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueues(queue);
        container.setMessageListener(adapter);
        container.setMessageConverter(jsonMessageConverter());
        return container;
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
