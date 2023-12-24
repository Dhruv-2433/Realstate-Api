package com.realstate.restfulapirealstate.broker;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class BrokerNotFoundExecption extends RuntimeException {
	
	public BrokerNotFoundExecption(String message) {
		super(message);
	}
}
