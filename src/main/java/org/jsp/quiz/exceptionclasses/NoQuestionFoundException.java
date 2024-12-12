package org.jsp.quiz.exceptionclasses;

import lombok.Builder;

@Builder
public class NoQuestionFoundException extends RuntimeException{

	private String s;
	public NoQuestionFoundException() {
	}
	public NoQuestionFoundException(String s) {
		this.s = s;
	}

	@Override
	public String getMessage(){
		return s;
	}
	
	
}
