package com.realstate.restfulapirealstate.client;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ClientNotFoundExecption extends RuntimeException {
	
	public ClientNotFoundExecption(String message) {
		super(message);
	}
}
