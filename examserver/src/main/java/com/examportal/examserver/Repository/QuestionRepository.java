package com.examportal.examserver.Repository;

import com.examportal.examserver.Model.Exam.Question;
import com.examportal.examserver.Model.Exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {

    public Set<Question> findByQuiz(Quiz quiz);
}
