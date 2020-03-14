package com.teach.me.app.Controller;

import com.teach.me.app.Model.Question;
import com.teach.me.app.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/insert")
    private void insertQuestion(@RequestBody Question question){
        questionService.insertQuestion(question);
    }
    @GetMapping("/all")
    private List getAllQuestions(){
        return questionService.getAllQuestions();
    }
    @GetMapping("/{id}")
    private Optional<Question> getQuestionById(@PathVariable int id){
        return questionService.getQuestionById(id);
    }
}
