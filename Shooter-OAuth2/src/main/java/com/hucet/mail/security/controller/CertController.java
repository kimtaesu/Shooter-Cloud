package com.hucet.mail.security.controller;

import com.hucet.mail.security.exception.EmailExpiredTokenException;
import com.hucet.mail.security.service.VerificationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/cert")
public class CertController {
    @Qualifier("frontUrlBean")
    @Autowired
    String frontUrl;

    @Autowired
    VerificationTokenService verificationTokenService;

    @GetMapping(value = "/confirm")
    ModelAndView certMail(@RequestParam("token") String token, ModelMap model) {
        if (verificationTokenService.isValid(token)) {
            return new ModelAndView("redirect:" + frontUrl + "/login");
        } else {
            throw new EmailExpiredTokenException("인증 기간이 만료되었습니다.");
        }


    }
}
