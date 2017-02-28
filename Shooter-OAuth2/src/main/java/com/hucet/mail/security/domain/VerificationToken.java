package com.hucet.mail.security.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class VerificationToken {
    private static final int EXPIRATION_HOUR = 24;

    @Id
    @GeneratedValue
    private Long id;

    private String token;

    @OneToOne(targetEntity = Account.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "ACCOUNT_ID")
    private Account account;

    @Temporal(TemporalType.DATE)
    private Date expiryDate;

    public VerificationToken(Account account, String token) {
        this.account = account;
        this.token = token;
        this.expiryDate = calculateExpiryDate();
    }

    private Date calculateExpiryDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, EXPIRATION_HOUR);
        return cal.getTime();
    }
}
