package com.teach.me.app.ServiceImpl;

import com.teach.me.app.Exception.QuestionNotFoundException;
import com.teach.me.app.Model.Question;
import com.teach.me.app.Repository.QuestionRepository;
import com.teach.me.app.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    /**
     * @param question
     */
    @Override
    public void insertQuestion(Question question) {
            questionRepository.save(question);
    }

    /**
     * @return
     */
    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Question getQuestionById(int id) throws QuestionNotFoundException {
        return questionRepository.findById(id).orElseThrow(QuestionNotFoundException::new);
    }

    @Override
    public List<Question> getAllQuestionByTestId(int testId) {
        return questionRepository.findAllByTestTestId(testId);
    }
}
