package com.examportal.examserver.Controller;

import com.examportal.examserver.Model.Exam.Category;
import com.examportal.examserver.Model.Exam.Quiz;
import com.examportal.examserver.Service.QuestionService;
import com.examportal.examserver.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Quiz addQuiz(@RequestBody Quiz quiz)
    {
        return quizService.addQuiz(quiz);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Quiz getQuizById(@PathVariable Long id)
    {
        return quizService.getQuizById(id);
    }
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public Set<Quiz> getAllQuiz()
    {
        return quizService.getAllQuiz();
    }

    @PutMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public Quiz updateQuiz(@RequestBody Quiz quiz)
    {
        return quizService.updateQuiz(quiz);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteQuizById(@PathVariable Long id)
    {
        quizService.deleteQuizById(id);
    }

    @GetMapping("/category/{cid}")
    @ResponseStatus(HttpStatus.OK)
    public List<Quiz> getQuizOfCategory(@PathVariable Long cid)
    {
        Category category = new Category();
        category.setId(cid);
        return quizService.getQuizByCategory(category);
    }

    @GetMapping("/active")
    @ResponseStatus(HttpStatus.OK)
    public List<Quiz> getActiveQuiz()
    {
        return quizService.getActiveQuiz();
    }

    @GetMapping("/category/active")
    @ResponseStatus(HttpStatus.OK)
    public List<Quiz> getActiveQuizOfCategory(@PathVariable Long cId)
    {
        Category category = new Category();
        category.setId(cId);
        return quizService.getActiveQuizOfCategory(category);
    }



}
