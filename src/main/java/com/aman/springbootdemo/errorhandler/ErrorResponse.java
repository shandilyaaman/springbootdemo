package com.aman.springbootdemo.errorhandler;

import java.util.List;

public class ErrorResponse {
	public List<String> details;
	public String message;

	public ErrorResponse(String message, List<String> details) {
		this.details = details;
		this.message = message;
	}

}
