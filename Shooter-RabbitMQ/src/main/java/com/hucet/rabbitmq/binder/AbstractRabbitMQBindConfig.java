package com.hucet.rabbitmq.binder;


import com.hucet.rabbitmq.listener.MQListener;
import com.hucet.rabbitmq.properties.BindRabbitMQProperties;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
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
@EnableConfigurationProperties(BindRabbitMQProperties.class)
public abstract class AbstractRabbitMQBindConfig<T> implements MQListener<T> {

    @Getter
    @Autowired
    BindRabbitMQProperties bindRabbitMQProperties;

    @Bean
    abstract protected Queue queue();

    @Bean
    abstract protected Exchange exchange();

    @Bean
    abstract protected Binding binding();

    @Bean
    MessageListenerAdapter listenerAdapter() {
        MessageListenerAdapter adapter = new MessageListenerAdapter(this);
        // RabbitMQ Defualt Method Name은 "handlerMessage" 이다.
        // 그 외 다른 명칭으로 구현할려면 아래의 함수로 Method 명을 지정해줘야한다.
        // 이게 무슨 경우인가...
//        adapter.setDefaultListenerMethod("Your method name");
        adapter.setMessageConverter(jsonMessageConverter());
        return adapter;
    }

    @Bean
    @Autowired
    SimpleMessageListenerContainer mssageListenerContainer(ConnectionFactory factory, Queue queue, MessageListenerAdapter adapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(factory);
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
