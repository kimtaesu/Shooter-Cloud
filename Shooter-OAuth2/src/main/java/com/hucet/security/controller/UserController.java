package com.hucet.security.controller;


import com.hucet.security.dto.AccountDto;
import com.hucet.security.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/signup", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    Long signup(@RequestBody @Valid AccountDto account, BindingResult result) {
        if (result.hasErrors()) {
            throw new ValidationException(result.toString());
        }
        return accountService.newAccount(account);
    }
}
