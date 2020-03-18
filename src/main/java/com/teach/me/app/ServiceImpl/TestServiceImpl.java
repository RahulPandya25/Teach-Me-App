package com.teach.me.app.ServiceImpl;

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
    public void insertTest(Test test) {
        testRepository.save(test);
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
    public Optional<Test> getTestById(int testId) {
        return testRepository.findById(testId);
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
