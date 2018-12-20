package com.az.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.az.services.EmailService;

@RestController
public class TestController {

	@Autowired
	private EmailService emailService;
	
	@GetMapping("email")
	public String testMail() {
		emailService.sendSimpleEmail("fromEmail@yourDomain.com", "toEmail@****.com", "Subject", "Body of email address");				
		return "Successfully Email Send";
	}
	
	@GetMapping("test")
	public String testMethod() {
		return "Testing...";
	}
}
