package org.jsp.quiz.ex_handler;

import org.jsp.quiz.exceptionclasses.InvalidQuEx;
import org.jsp.quiz.exceptionclasses.NoQuestionFoundException;
import org.jsp.quiz.responsestructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class QuationExceptionHandler {
	
	@ExceptionHandler(NoQuestionFoundException.class)
	public ResponseEntity<?> noQuestionExceptionHandler(NoQuestionFoundException e){
	
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(ResponseStructure
						.builder()
						.httpStatus(HttpStatus.NOT_FOUND.value())
						.message("No Quetions in DB")
						.body("No Quetions found in database")
						.build());
	}
	@ExceptionHandler(InvalidQuEx.class)
	public ResponseEntity<?> invalidQuestionExceptionHandler(InvalidQuEx e){
	
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(ResponseStructure
						.builder()
						.httpStatus(HttpStatus.NOT_FOUND.value())
						.message("Invalid Quetions in DB")
						.body("No Quetions found in database")
						.build());
	}
}
