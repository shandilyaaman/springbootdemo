package com.aman.springbootdemo.controller;

import javax.ws.rs.NotFoundException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {
	@ExceptionHandler(NotFoundException.class)
	public String pageNotFound() {
		return "error";
	}
}
