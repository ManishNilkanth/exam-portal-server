package com.examportal.examserver.Service.ServiceImplimentation;

import com.examportal.examserver.Model.Exam.Category;
import com.examportal.examserver.Model.Exam.Quiz;
import com.examportal.examserver.Repository.QuizRepository;
import com.examportal.examserver.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Override
    public Quiz addQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Quiz getQuizById(Long id) {
        return quizRepository.findById(id).get();
    }

    @Override
    public Set<Quiz> getAllQuiz() {
        return new HashSet<>(quizRepository.findAll());
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public void deleteQuizById(Long id) {
       quizRepository.deleteById(id);
    }

    @Override
    public List<Quiz> getQuizByCategory(Category category) {
        return quizRepository.findByCategory(category);
    }

    @Override
    public List<Quiz> getActiveQuiz() {
        return quizRepository.findByActive(true);
    }

    @Override
    public List<Quiz> getActiveQuizOfCategory(Category category) {
        return quizRepository.findByCategoryAndActive(category,true);
    }
}
