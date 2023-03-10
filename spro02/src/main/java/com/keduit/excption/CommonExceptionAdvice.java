package com.keduit.excption;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;

//컨트롤러에서 발생하는 에러를 처리해줘라는의미 ?
@ControllerAdvice

@Log4j
public class CommonExceptionAdvice {
	
	//예외 처리 
	@ExceptionHandler
	public String except(Exception ex, Model model) {
		log.error("Exception........."+ex.getMessage());
		model.addAttribute("exception",ex);
		log.error(model);
		return "error_page";
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handle404(NoHandlerFoundException ex) {
		return "custom404";
	}
	
	
	/////////////////////
}
