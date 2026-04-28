package com.rays.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class EmailConfig {

    @Value("${smtp.server}")
    private String smtpServer;

    @Value("${smtp.port}")
    private String smtpPort;

    @Value("${email.login}")
    private String emailLogin;

    @Value("${email.pwd}")
    private String emailPwd;

     public static String SMTP_SERVER;
    public static String SMTP_PORT;
    public static String EMAIL_LOGIN;
    public static String EMAIL_PWD;

    @PostConstruct
    public void init() {
        SMTP_SERVER = smtpServer;
        SMTP_PORT   = smtpPort;
        EMAIL_LOGIN = emailLogin;
        EMAIL_PWD   = emailPwd;
    }
}