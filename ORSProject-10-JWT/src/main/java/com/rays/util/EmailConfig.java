package com.rays.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Configuration component for email-related properties.
 * <p>
 * Loads SMTP server details and email credentials from application
 * properties using Spring's {@link Value} annotation. These values
 * are then assigned to static fields for global access throughout
 * the application.
 * </p>
 *
 * <p>
 * This approach allows email services to easily access configuration
 * values without requiring dependency injection in every class.
 * </p>
 *
 * Example properties:
 * <pre>
 * smtp.server=smtp.example.com
 * smtp.port=587
 * email.login=myemail@example.com
 * email.pwd=secret
 * </pre>
 *
 * @author Aditya
 * @version 1.0
 */
@Component
public class EmailConfig {

    /** SMTP server hostname (injected from application properties). */
    @Value("${smtp.server}")
    private String smtpServer;

    /** SMTP server port (injected from application properties). */
    @Value("${smtp.port}")
    private String smtpPort;

    /** Email login username (injected from application properties). */
    @Value("${email.login}")
    private String emailLogin;

    /** Email login password (injected from application properties). */
    @Value("${email.pwd}")
    private String emailPwd;

    /** Static reference to SMTP server hostname. */
    public static String SMTP_SERVER;

    /** Static reference to SMTP server port. */
    public static String SMTP_PORT;

    /** Static reference to email login username. */
    public static String EMAIL_LOGIN;

    /** Static reference to email login password. */
    public static String EMAIL_PWD;

    /**
     * Initializes static fields with values injected by Spring.
     * <p>
     * This method runs automatically after dependency injection
     * is complete, ensuring that static fields are populated
     * before being accessed elsewhere in the application.
     * </p>
     */
    @PostConstruct
    public void init() {
        SMTP_SERVER = smtpServer;
        SMTP_PORT   = smtpPort;
        EMAIL_LOGIN = emailLogin;
        EMAIL_PWD   = emailPwd;
    }
}
