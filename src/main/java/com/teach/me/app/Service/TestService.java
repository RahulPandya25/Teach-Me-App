package com.teach.me.app.Service;

import com.teach.me.app.Exception.TestNotFoundException;
import com.teach.me.app.Model.Test;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TestService {
    /**
     *
     * @param test
     */
     Test insertTest(Test test);

    /**
     *
     * @return
     */
     List<Test> getAllTests();

    /**
     *
     * @param id
     * @return
     */
     Test getTestById(int id) throws TestNotFoundException;

    /**
     *
     * @param id
     * @return
     */
    List<Test> getTestsBySubjectId(int id);
}
