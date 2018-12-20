package com.az;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootApplication
@ComponentScan(basePackages= {"com.az"})
public class EmailProjectApplication {

	
	@Value("${smtp.server.host}")
	private String SMTP_SERVER_HOST;
	
	
	@Value("${smtp.server.password}")
	private String SMTP_SERVER_PASSWORD;
	
	@Value("${smtp.server.username}")
	private String SMTP_SERVER_USERNAME;
	
	@Value("${smtp.server.port}")
	private int SMTP_SERVER_PORT;
	
	@Value("${smtp.server.auth}")
	private Boolean SMTP_SERVER_AUTH;
	
	@Value("${smtp.server.starttls.enable}")
	private Boolean SMTP_SERVER_STARTTLS;

	
	public static void main(String[] args) {
		SpringApplication.run(EmailProjectApplication.class, args);
		
		
		
	}

	
	@Bean
	public JavaMailSender getJavaMailSender() {
	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    mailSender.setHost(SMTP_SERVER_HOST);
	    mailSender.setPort(SMTP_SERVER_PORT);
	     
	    //mailSender.setUsername(SMTP_SERVER_USERNAME);
	    //mailSender.setPassword(SMTP_SERVER_PASSWORD);
	     
	    Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", SMTP_SERVER_AUTH);
	    props.put("mail.smtp.starttls.enable", SMTP_SERVER_STARTTLS);
	    props.put("mail.debug", "true");
	     
	    return mailSender;
	}
		
}

