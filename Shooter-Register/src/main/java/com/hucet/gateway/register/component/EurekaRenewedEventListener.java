package com.hucet.gateway.register.component;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRenewedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EurekaRenewedEventListener implements ApplicationListener<EurekaInstanceRenewedEvent> {
    @Override
    public void onApplicationEvent(EurekaInstanceRenewedEvent event) {
        log.info("event.getInstanceInfo() = " + event.toString());
    }
}
