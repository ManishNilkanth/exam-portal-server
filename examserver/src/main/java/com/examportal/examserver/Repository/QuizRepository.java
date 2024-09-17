package com.examportal.examserver.Repository;

import com.examportal.examserver.Model.Exam.Category;
import com.examportal.examserver.Model.Exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QuizRepository extends JpaRepository<Quiz,Long> {

    public List<Quiz> findByCategory(Category category);
    public List<Quiz> findByActive(Boolean b);
    public List<Quiz> findByCategoryAndActive(Category category,Boolean b);
}
