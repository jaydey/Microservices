package com.circuitbreaker.emailservice.main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emailService")
public class EmailController {

	@GetMapping("/sendEmail")
	public String sendEmail() {
		return "Email send successfully....";
	}
}
