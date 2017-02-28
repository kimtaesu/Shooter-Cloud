package com.hucet.mail;

import com.hucet.mail.service.MailSendService;
import com.hucet.mail.type.EmailType;
import com.hucet.shared.MailDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

//@EnableDiscoveryClient
@SpringBootApplication
@RestController
@Slf4j
public class ShooterMailApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShooterMailApplication.class, args);
    }

    // TODO Remove Test code
    @Autowired
    MailSendService mailSendService;

    @RequestMapping(method = RequestMethod.GET, value = "/confirm")
    void test1(@RequestParam String token) {
        log.info("test1 " + token);
    }

    @RequestMapping(method = RequestMethod.GET)
    void test() {
        mailSendService.mailSend(EmailType.EMAIL_CERT, new MailDto("taesu",
                "kimtaesoo188@gmail.com",
                "saad",
                new Date().getTime(),
                "http://localhost:8084/confirm"));
    }
}
