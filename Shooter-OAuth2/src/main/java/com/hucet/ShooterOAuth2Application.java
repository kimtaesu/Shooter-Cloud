package com.hucet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
//@EnableDiscoveryClient
// transaction 을 CGLIB 를 통해서 proxy를 생성하도록 수행
// @transaction interface 영역에서 동작을 하지 않기 때문에 선언
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ShooterOAuth2Application {

    public static void main(String[] args) {
        SpringApplication.run(ShooterOAuth2Application.class, args);
    }
}
