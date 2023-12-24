package com.realstate.restfulapirealstate.property;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PropertyNotFoundExecption extends RuntimeException {
	
	public PropertyNotFoundExecption(String message) {
		super(message);
	}
}
