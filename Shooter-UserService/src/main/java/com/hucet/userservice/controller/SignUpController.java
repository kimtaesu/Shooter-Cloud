package com.hucet.userservice.controller;

import com.hucet.userservice.dto.AccountDto;
import com.hucet.userservice.service.AccountStreamService;
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
    AccountStreamService accountStreamService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    Long signup(@RequestBody @Valid AccountDto user, BindingResult result) {
        if (result.hasErrors()) {
            throw new ValidationException(result.toString());
        }
        String value = "{\"value\":\"hi\"}";
        accountStreamService.accountSend(user);
        return new Long(1);
    }
}
