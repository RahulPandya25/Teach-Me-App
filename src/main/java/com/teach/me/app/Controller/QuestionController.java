package com.teach.me.app.Controller;

import com.teach.me.app.Exception.QuestionNotFoundException;
import com.teach.me.app.Model.Question;
import com.teach.me.app.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/question/insert")
    private void insertQuestion(@RequestBody Question question){
        questionService.insertQuestion(question);
    }
    @GetMapping("/question/all")
    private List getAllQuestions(){
        return questionService.getAllQuestions();
    }
    @GetMapping("/question/{id}")
    private Question getQuestionById(@PathVariable int id) throws QuestionNotFoundException {
        return questionService.getQuestionById(id);
    }

    @GetMapping("/test/questions/{testId}")
    private List<Question> getQuestionsByTestId(@PathVariable int testId){
        return  questionService.getAllQuestionByTestId(testId);
    }

}
