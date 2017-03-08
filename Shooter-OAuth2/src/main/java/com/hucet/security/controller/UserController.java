package com.hucet.security.controller;


import com.hucet.security.domain.Account;
import com.hucet.security.dto.UserDto;
import com.hucet.security.event.OnAccountRegistered;
import com.hucet.security.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    AccountService accountService;

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @RequestMapping(value = "/signup", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    Long signup(@RequestBody @Valid UserDto.JoinDto dto, BindingResult result) {
        if (result.hasErrors()) {
            throw new ValidationException(result.toString());
        }

        Account account = accountService.newAccount(dto);
        eventPublisher.publishEvent(new OnAccountRegistered(this, account));
        return account.getId();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    void login(@RequestBody @Valid UserDto.LoginDto dto, BindingResult result) {
        if (result.hasErrors()) {
            throw new ValidationException(result.toString());
        }
    }
}
