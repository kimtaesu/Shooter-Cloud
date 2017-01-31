package com.hucet.userservice.controller;

import com.hucet.userservice.domain.Account;
import com.hucet.userservice.dto.AccountDto;
import com.hucet.userservice.service.AccountService;
import com.hucet.userservice.service.EmailService;
import com.hucet.userservice.service.OAuth2UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;

@RestController
@Slf4j
public class SignUpController {

    @Autowired
    AccountService userService;

    @Autowired
    EmailService emailService;

    @Autowired
    OAuth2UserService oAuth2UserService;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Integer test() {
        return null;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Integer signup(@RequestBody @Valid AccountDto.ApplicationRequest user, BindingResult result) {
        if (result.hasErrors()) {
            // TODO Exception
            throw new ValidationException(result.toString());
        }

        Account savedAccount = userService.newUser(user);

        // TODO Transaction dabase for user
        oAuth2UserService.notifyOAuthUserAdded(user, rabbitTemplate);
        emailService.notifyEmailCert(user, rabbitTemplate);
        return null;
    }
}
