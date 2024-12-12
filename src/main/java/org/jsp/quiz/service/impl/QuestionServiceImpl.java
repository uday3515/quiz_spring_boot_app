package org.jsp.quiz.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jsp.quiz.dao.QuestionDao;

import org.jsp.quiz.dto.QuestionDto;
import org.jsp.quiz.dto.QuizResponse;
import org.jsp.quiz.entity.Question;
import org.jsp.quiz.exceptionclasses.InvalidQuEx;
import org.jsp.quiz.exceptionclasses.NoQuestionFoundException;
import org.jsp.quiz.responsestructure.ResponseStructure;
import org.jsp.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	private QuestionDao dao;
	
	@Override
	public ResponseEntity<?> saveQuestion(Question question) {
		 question= dao.save(question);
		 return ResponseEntity.status(HttpStatus.OK)
					.body(
							ResponseStructure
							.builder()
							.httpStatus(HttpStatus.OK.value())
							.message("All Questions Found")
							.body(question)
							.build()
					);
	}

	@Override
	public ResponseEntity<?> findAllQuestions() {
//		List<Question> questions= dao.findAllQuestions();
		List<Question> questions= dao.findAllActiveQuestions();
		
		List<QuestionDto> dtoList =new ArrayList<>();
		for(Question q:questions) {
			dtoList.add(new QuestionDto(q.getTitle(), q.getA(), q.getB(), q.getC(), q.getD()));
		}
		
		if(questions.isEmpty())
			throw NoQuestionFoundException.builder().s("No Question Found In Database").build();
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(
						ResponseStructure
						.builder()
						.httpStatus(HttpStatus.OK.value())
						.message("All Questions Found")
						.body(dtoList)
						.build()
				);
	}

	@Override
	public ResponseEntity<?> findQueationById(int id) {
		Optional<Question> optional=dao.findQueationById(id);
		if(optional.isEmpty())
			throw InvalidQuEx.builder().message("Invalid Question Found In Database").build();
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(
						ResponseStructure
						.builder()
						.httpStatus(HttpStatus.OK.value())
						.message("All Questions Found")
						.body(optional)
						.build()
				);
	}

	@Override
	public ResponseEntity<?> submitQuiz(List<QuizResponse> quizResponses) {
		int count=0;
		for(QuizResponse qr:quizResponses) {
			Optional<Question> q=	dao.findQueationById(qr.getId());
			
			Question question =q.get();
			if(question.getAns().equalsIgnoreCase(qr.getAns())) {
				count++;
			}
		}
		return ResponseEntity.status(HttpStatus.OK)
				.body(
						ResponseStructure
						.builder()
						.httpStatus(HttpStatus.OK.value())
						.message("Submition Successfully")
						.body("Your Score :"+count)
						.build()
				);
	}

	@Override
	public ResponseEntity<?> takeQuiz() {
		List<Question> question=dao.findRandomQuestions();
		return null;
	}

}
