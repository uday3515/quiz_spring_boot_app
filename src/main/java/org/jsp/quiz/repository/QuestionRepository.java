package org.jsp.quiz.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.jsp.quiz.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuestionRepository extends JpaRepository<Question, Integer>{
	@Query("select q from Question q where q.status='ACTIVE'")
	List<Question> findAllActiveQuestions();
	@Query("select q from Quation order by function('RAND') ASC")
	List<Question> findRandomQuestions(Pageable pageble);

}
