package com.hucet.mail.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cert")
public class CertController {
    @GetMapping(value = "/confirm")
    void certMail() {

    }
}
