package com.hucet.userservice.service;

import com.hucet.common.exception.server.BusinessException;
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
    Object syncOAuthUserAdded(AccountDto dto);

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
        public Object syncOAuthUserAdded(AccountDto dto) {
            OAuth2UserDto auth2UserDto = mapper.map(dto, OAuth2UserDto.class);
            Object isSuccess = rabbitTemplate.convertSendAndReceive(getOAuthProperty(bindRabbitMQProperties).getExchange(),
                    getOAuthProperty(bindRabbitMQProperties).getRountingKey(),
                    auth2UserDto);
            if (isSuccess == null) {
                log.error("Fail to save for user of OAuth");
                throw new BusinessException("인증 서버 연결을 실패하였습니다.");
            }
            return isSuccess;
        }
    }
}
