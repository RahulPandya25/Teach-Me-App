package com.teach.me.app.Service;

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
     void insertTest(Test test);

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
     Optional<Test> getTestById(int id);

    /**
     *
     * @param id
     * @return
     */
    List<Test> getTestsBySubjectId(int id);
}
