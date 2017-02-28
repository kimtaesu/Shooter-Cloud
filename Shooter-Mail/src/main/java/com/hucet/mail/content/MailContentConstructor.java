package com.hucet.mail.content;

import com.hucet.mail.properties.MailConfProperties;
import com.hucet.mail.type.EmailType;
import com.hucet.shared.MailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Collections;

/**
 * Created by taesu on 2017-01-26.
 */
@Component
public class MailContentConstructor {

    @Autowired
    MailConfProperties mailConfProperties;

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    TemplateEngine templateEngine;

    public MimeMessage createMimeMessageForEmailCertification(MailDto dto) throws MessagingException {
        final MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        final MimeMessageHelper message; // true = multipart

        message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        message.setFrom(mailConfProperties.getEmail());
        // TODO Subject
        message.setSubject("본인 인증 메일");
        message.setTo(dto.getUserEmail());
        final String htmlContent = createHtmlContentForEmailCertification(EmailType.EMAIL_CERT, dto);

        message.setText(htmlContent, true); // true = isHtml

        return mimeMessage;
    }

    private String createHtmlContentForEmailCertification(EmailType emailCert, MailDto dto) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        String expiryDate = format.format(dto.getExpiryDate());
        // Create the HTML body using Thymeleaf
        final Context ctx = new Context();
        ctx.setVariable("userName", dto.getUserName());
        ctx.setVariable("expiryDate", expiryDate);
        ctx.setVariable("confirmUrl", getConfirmMailUrl(dto));
        return this.templateEngine.process(emailCert.getTemplateName(), ctx);
    }

    private String getConfirmMailUrl(MailDto dto) {
        LinkedMultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.put("token", Collections.singletonList(dto.getToken()));
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(dto.getConfirmUrl());
        return builder.queryParams(params).build().toUriString();
    }
}
