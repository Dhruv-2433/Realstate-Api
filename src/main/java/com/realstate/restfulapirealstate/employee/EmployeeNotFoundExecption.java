package com.realstate.restfulapirealstate.employee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EmployeeNotFoundExecption extends RuntimeException {
 
	public EmployeeNotFoundExecption(String message) {
		super(message);
	}
}
