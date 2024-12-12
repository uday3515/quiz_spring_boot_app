package org.jsp.quiz.service;

import java.awt.desktop.QuitResponse;
import java.util.List;

import org.jsp.quiz.dto.QuizResponse;
import org.jsp.quiz.entity.Question;
import org.springframework.http.ResponseEntity;

public interface QuestionService {

	ResponseEntity<?> saveQuestion(Question question);

	ResponseEntity<?> findAllQuestions();

	ResponseEntity<?> findQueationById(int id);



	ResponseEntity<?> submitQuiz(List<QuizResponse> quizResponses);

	ResponseEntity<?> takeQuiz();

}
