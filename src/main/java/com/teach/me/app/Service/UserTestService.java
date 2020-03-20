package com.teach.me.app.Service;

import com.teach.me.app.Model.Test;
import com.teach.me.app.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserTestService {
    /**
     *
     * @param userId
     * @return
     */
    public List<Test> getAllTestsbyUserId(int userId);

    /**
     *
     * @param userId
     * @param testId
     * @return
     */
    public boolean isTestAttempted(int userId, int testId);

    /**
     *
     * @param testId
     * @return
     */
    public List<User>  getStudentByTestId(int testId);


}
