package com.hucet.security.controller;

import com.hucet.security.domain.Account;
import com.hucet.security.event.OnAccountRegistered;
import com.hucet.security.exception.EmailExpiredTokenException;
import com.hucet.security.service.AccountService;
import com.hucet.security.service.VerificationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/mail")
public class MailController {
    @Qualifier("frontUrlBean")
    @Autowired
    String frontUrl;

    @Autowired
    VerificationTokenService verificationTokenService;

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @Autowired
    AccountService accountService;

    @GetMapping(value = "/confirm")
    ModelAndView certMail(@RequestParam("token") String token, ModelMap model) {
        if (verificationTokenService.isValid(token)) {
            return new ModelAndView("redirect:" + frontUrl + "/home");
        } else {
            // TODO Catch
            throw new EmailExpiredTokenException("인증 기간이 만료되었습니다.");
        }
    }

    @GetMapping(value = "/resend")
    @ResponseStatus(code = HttpStatus.OK)
    void resendMail(@RequestParam("userEmail") String userEmail) {
        Account account = accountService.getUser(userEmail);
        eventPublisher.publishEvent(new OnAccountRegistered(this, account));
    }
}
