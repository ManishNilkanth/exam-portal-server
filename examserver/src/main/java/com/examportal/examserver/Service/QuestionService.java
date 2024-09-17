package com.examportal.examserver.Service;

import com.examportal.examserver.Model.Exam.Question;
import com.examportal.examserver.Model.Exam.Quiz;

import java.util.Set;

public interface QuestionService {

    public Question addQuestion(Question question);

    public Question updateQuestion(Question question);

    public Question getQuestionById(Long id);

    public Set<Question> getQuestionByQuiz(Quiz quiz);

    public void deleteQuestionById(Long id);

}
