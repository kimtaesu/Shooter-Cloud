package com.hucet.mail.security.controller;

import com.hucet.mail.security.service.VerificationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cert")
public class CertController {
    @Autowired
    VerificationTokenService verificationTokenService;

    @GetMapping(value = "/confirm")
    void certMail(@RequestParam("token") String token) {
        verificationTokenService.isValid(token);
    }
}
