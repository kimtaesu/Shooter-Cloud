package com.hucet.rabbitmq.listener;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public interface MQListener<T> {
    public static final String METHOD_NAME = "onReceivedMessage";

    public void onReceivedMessage(T dto);
}
