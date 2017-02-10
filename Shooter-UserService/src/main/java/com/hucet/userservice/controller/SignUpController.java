package com.hucet.userservice.controller;

import com.hucet.userservice.domain.Account;
import com.hucet.userservice.dto.AccountDto;
import com.hucet.userservice.service.AccountService;
import com.hucet.userservice.service.EmailService;
import com.hucet.userservice.service.OAuth2UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;

@RestController
@Slf4j
@Validated
class SignUpController {

    @Autowired
    AccountService userService;

    @Autowired
    EmailService emailService;

    @Autowired
    OAuth2UserService oAuth2UserService;


    @RequestMapping(value = "/signup", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    Long signup(@RequestBody @Valid AccountDto user, BindingResult result) {
        if (result.hasErrors()) {
            throw new ValidationException(result.toString());
        }
        Account account = userService.newUser(user);
//        emailService.notifyEmailCert(user, rabbitTemplate);
        return account.getId();
    }
}
