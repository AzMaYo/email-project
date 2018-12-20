/**
 * 
 */
package com.az.services;

import java.io.File;
import java.io.Serializable;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

/**
 * @author Azhar Mobeen
 *
 */
@Component
public class EmailService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private JavaMailSender emailSender;
	
	public void sendSimpleEmail(String from,String to, String subject, String body) {
		        
		SimpleMailMessage message = new SimpleMailMessage(); 
		message.setFrom(from);
		message.setTo(to); 
        message.setSubject(subject); 
        message.setText(body);        
        emailSender.send(message);
     
    }
	
	public void sendEmailWithAttachments(String from,String to, String subject, String body,String filePath) {
        
		
		MimeMessage message = null;
		MimeMessageHelper helper = null;
		try {
			message = emailSender.createMimeMessage();
			helper = new MimeMessageHelper(message, true);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body);
			FileSystemResource file = new FileSystemResource(new File(filePath));
			helper.addAttachment(file.getFilename(), file);	 
		    //emailSender.send(message);
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}		
    }
	
}
