package com.hucet.register.component;


import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRenewedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EurekaRenewedEventListener implements ApplicationListener<EurekaInstanceRenewedEvent> {
    @Override
    public void onApplicationEvent(EurekaInstanceRenewedEvent event) {
        System.out.println("event.getInstanceInfo() = " + event.toString());
    }
}
