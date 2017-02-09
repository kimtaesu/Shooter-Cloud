package com.hucet.userservice.service;

import com.hucet.common.exception.server.MQBindingConfigException;
import com.hucet.rabbitmq.dto.OAuth2UserDto;
import com.hucet.rabbitmq.properties.BindRabbitMQProperties;
import com.hucet.userservice.dto.AccountDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by taesu on 2017-01-31.
 */
public interface OAuth2UserService {
    void syncOAuthUserAdded(AccountDto.ApplicationRequest dto);

    @Service
    @Transactional
    @Slf4j
    class Impl implements OAuth2UserService {

        @Autowired
        ModelMapper mapper;

        @Autowired
        RabbitTemplate rabbitTemplate;

        private BindRabbitMQProperties.BindingProperties oauthProperty;

        @Autowired
        BindRabbitMQProperties bindRabbitMQProperties;

        BindRabbitMQProperties.BindingProperties getOAuthProperty(BindRabbitMQProperties properties) {
            if (oauthProperty == null) {
                String oauthKey = "oauth";
                if (properties.getBinding().containsKey(oauthKey)) {
                    oauthProperty = properties.getBinding().get(oauthKey);
                } else {
                    throw new MQBindingConfigException("MQ Bind 설정 에러입니다.");
                }
            }
            return oauthProperty;
        }

        @Override
        public void syncOAuthUserAdded(AccountDto.ApplicationRequest dto) {
            OAuth2UserDto auth2UserDto = mapper.map(dto, OAuth2UserDto.class);
            rabbitTemplate.convertAndSend(getOAuthProperty(bindRabbitMQProperties).getExchange(),
                    getOAuthProperty(bindRabbitMQProperties).getRountingKey(),
                    auth2UserDto);
//            if (received == null)
//                throw new MQReceiveTimeoutRestException("인증 서버로 부터 응답이 없습니다.");
        }
    }
}
