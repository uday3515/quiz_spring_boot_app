package org.jsp.quiz.exceptionclasses;


import lombok.Builder;
@Builder
public class InvalidQuEx extends RuntimeException{
	private String message;
	public InvalidQuEx(){
		
	}
	public InvalidQuEx(String s) {
		this.message=s;
	}
	@Override
	public String getMessage() {
		return message;
	}
	
}
