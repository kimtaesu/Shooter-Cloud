package com.hucet.mail.stream;

import com.hucet.mail.service.MailSendService;
import com.hucet.mail.stream.dto.MailDto;
import com.hucet.mail.stream.processor.JoinProcessor;
import com.hucet.mail.type.EmailType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@EnableBinding(JoinProcessor.class)
@Slf4j
@Service
public class JoinStreamService {
    @Autowired
    JoinProcessor processor;

    @Autowired
    MailSendService mailSendService;

    @StreamListener(JoinProcessor.INPUT)
    public void joinHandler(MailDto dto) {
        log.info("consume " + dto.toString());
        mailSendService.mailSend(EmailType.EMAIL_CERT, dto);
    }
}
