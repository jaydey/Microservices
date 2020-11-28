package com.circuitbreaker.paymentservice.main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paymentService")
public class PaymentController {

	@GetMapping("/payTicket")
	public String payTicket() {
		return "Payment done successfully....";
	}
}
