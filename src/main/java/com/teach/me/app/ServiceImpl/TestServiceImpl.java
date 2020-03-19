package com.teach.me.app.ServiceImpl;

import com.teach.me.app.Exception.TestNotFoundException;
import com.teach.me.app.Model.Test;
import com.teach.me.app.Repository.TestRepository;
import com.teach.me.app.Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepository testRepository;
    /**
     * @param test
     */
    @Override
    public Test insertTest(Test test) {
        return testRepository.save(test);
    }

    /**
     * @return
     */
    @Override
    public List<Test> getAllTests() {
        return testRepository.findAll();
    }

    /**
     * @param testId
     * @return
     */
    @Override
    public Test getTestById(int testId) throws TestNotFoundException {
        return testRepository.findById(testId).orElseThrow(TestNotFoundException::new);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public List<Test> getTestsBySubjectId(int id) {
        return testRepository.getAllBySubject_SubjectId(id);
    }
}
