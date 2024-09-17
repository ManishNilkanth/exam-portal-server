package com.examportal.examserver.Controller;

import com.examportal.examserver.Model.Exam.Question;
import com.examportal.examserver.Model.Exam.Quiz;
import com.examportal.examserver.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Question addQuestion(@RequestBody Question question)
    {
        return questionService.addQuestion(question);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Question getQuestionById(@PathVariable Long id)
    {
        return questionService.getQuestionById(id);
    }

    @GetMapping("/quiz/{id}")
    public List<Question> getQuestionByQuiz(@PathVariable Long id)
    {
        Quiz quiz = questionService.getQuestionById(id).getQuiz();
        Set<Question> questions = quiz.getQuestions();
        List<Question> list = new ArrayList<>(questions);
        if(list.size() > Integer.parseInt(quiz.getNumberOfQuestion()))
        {
            list = list.subList(0,Integer.parseInt(quiz.getNumberOfQuestion()+1));
        }
        list.forEach((q)->{
            q.setAnswer("");
        });

        Collections.shuffle(list);
        return list;
    }

    @PutMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public Question updateQuestion(@RequestBody Question question)
    {
        return questionService.updateQuestion(question);
    }

    @PostMapping("/eval-Quiz")
    public Map evalQuiz(@RequestBody List<Question> questions)
    {
        double marksGot = 0;
        int correctAnswer = 0;
        int attempted = 0;

        for(Question q: questions)
        {
            Question question = questionService.getQuestionById(q.getId());

            if(question.getAnswer().equals(q.getChosenAnswer()))
            {
                correctAnswer++;

                double marksSingle = Double.parseDouble(questions.get(0).getQuiz().getMaxMarks())/questions.size();
                marksGot += marksSingle;
            }
            if(q.getChosenAnswer() != null )
            {
                attempted++;
            }
        }

        Map<String,Object> map = Map.of("marksGot",marksGot,"correctAnswers",correctAnswer,"attempted",attempted);
        return map;
    }
}
