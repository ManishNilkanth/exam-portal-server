package com.examportal.examserver.Service;


import com.examportal.examserver.Model.Exam.Category;
import com.examportal.examserver.Model.Exam.Quiz;

import java.util.List;
import java.util.Set;


public interface QuizService {

    public Quiz addQuiz(Quiz quiz);

    public Quiz getQuizById(Long id);

    public Set<Quiz> getAllQuiz();

    public Quiz updateQuiz(Quiz quiz);

    public void deleteQuizById(Long id);

    public List<Quiz> getQuizByCategory(Category category);

    public List<Quiz> getActiveQuiz();

    public List<Quiz> getActiveQuizOfCategory(Category category);

}
