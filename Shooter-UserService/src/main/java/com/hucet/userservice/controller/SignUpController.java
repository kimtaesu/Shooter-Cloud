package com.hucet.userservice.controller;

import com.hucet.userservice.domain.Account;
import com.hucet.userservice.dto.AccountDto;
import com.hucet.userservice.service.AccountService;
import lombok.extern.slf4j.Slf4j;
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

        // TODO CREATE OAUTH USER with RPC

//        emailService.notifyEmailCert(user);


        return null;
    }
}
