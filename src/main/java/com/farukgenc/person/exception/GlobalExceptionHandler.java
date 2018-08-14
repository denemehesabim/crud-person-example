package com.farukgenc.person.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.farukgenc.person.web.resources.ErrorResource;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = PersonNotFoundException.class)
	public @ResponseBody ResponseEntity<ErrorResource> personNotFoundEx(HttpServletRequest request,
			PersonNotFoundException e) throws Exception {
		return new ResponseEntity<ErrorResource>(new ErrorResource(e.getErrorCode(), e.getDescription()),
				HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = DepartmentNotFoundException.class)
	public @ResponseBody ResponseEntity<ErrorResource> departmentNotFoundEx(HttpServletRequest request,
			DepartmentNotFoundException e) throws Exception {
		return new ResponseEntity<ErrorResource>(new ErrorResource(e.getErrorCode(),e.getDescription()),HttpStatus.NOT_FOUND);
	}

}
