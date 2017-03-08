package com.hucet.shared.dto;

import java.io.Serializable;

public class MailDto implements Serializable {
    private String userName;
    private String userEmail;
    private Long expiryDate;
    private String confirmUrl;
    private String token;

    public MailDto() {
    }

    public MailDto(String userName, String userEmail, String token, Long expiryDate, String confirmUrl) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.token = token;
        this.confirmUrl = confirmUrl;
        this.expiryDate = expiryDate;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getConfirmUrl() {
        return confirmUrl;
    }

    public Long getExpiryDate() {
        return expiryDate;
    }

    public String getToken() {
        return token;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setExpiryDate(Long expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setConfirmUrl(String confirmUrl) {
        this.confirmUrl = confirmUrl;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
