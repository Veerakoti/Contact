package com.example.demo.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class ContactNotFoundException {
	@ExceptionHandler(value = ContactException.class)
	public String handleContactException() {
		return "error";
	}

}
