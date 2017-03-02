package com.hucet.mail.security.domain;

import com.hucet.mail.security.utils.Utils;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class VerificationToken {


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
        this.expiryDate = Utils.calculateExpiryDate();
    }

}
