package com.circuitbreaker.bookticket.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class BookTicketController {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(groupKey = "circuit breaker", commandKey = "circuit breaker", fallbackMethod = "bookTicketFallBack")
	@GetMapping("/bookTicket")
	public String bookTicket() {
		String emailServiceResponse = restTemplate.getForObject("http://localhost:4041/emailService/sendEmail",
				String.class);
		String paymentServiceResponse = restTemplate.getForObject("http://localhost:4042/paymentService/payTicket",
				String.class);
		return emailServiceResponse + "\n" + paymentServiceResponse;
	}

	@GetMapping("/bookNowWitoutHystrix")
	public String bookShowWitoutHystrix() {
		String emailServiceResponse = restTemplate.getForObject("http://localhost:4041/emailService/sendEmail",
				String.class);
		String paymentServiceResponse = restTemplate.getForObject("http://localhost:4042/paymentService/payTicket",
				String.class);
		return emailServiceResponse + "\n" + paymentServiceResponse;
	}

	public String bookTicketFallBack() {
		return "Fallback method called...";
	}

}
