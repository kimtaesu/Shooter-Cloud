package com.hucet.mail;

import com.hucet.mail.service.MailSendService;
import com.hucet.mail.stream.dto.MailDto;
import com.hucet.mail.type.EmailType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class ShooterMailApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShooterMailApplication.class, args);
    }

    @Autowired
    MailSendService mailSendService;

    @RequestMapping(method = RequestMethod.GET)
    void test() {
        mailSendService.mailSend(EmailType.EMAIL_CERT, new MailDto("taesu", "kimtaesoo188@gmail.com"));
    }
}
