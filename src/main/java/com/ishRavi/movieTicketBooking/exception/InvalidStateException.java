package com.ishRavi.movieTicketBooking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidStateException extends RuntimeException {
	public InvalidStateException(String message) {
		super(message);
	}
}
