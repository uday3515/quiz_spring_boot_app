package org.jsp.quiz.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.quiz.entity.Question;

public interface QuestionDao {

	Question save(Question question);

	List<Question> findAllQuestions();

	Optional<Question> findQueationById(int id);

	List<Question> findAllActiveQuestions();

	List<Question> findRandomQuestions();
	

}
