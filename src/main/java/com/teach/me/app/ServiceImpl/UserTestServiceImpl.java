package com.teach.me.app.ServiceImpl;

import com.teach.me.app.Model.Test;
import com.teach.me.app.Model.User;
import com.teach.me.app.Model.UserTest;
import com.teach.me.app.Repository.UserRepository;
import com.teach.me.app.Repository.UserTestRepository;
import com.teach.me.app.Service.UserTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserTestServiceImpl implements UserTestService {

    @Autowired
    private UserTestRepository userTestRepository;
    /**
     * @param userId
     * @return
     */
    @Override
    public List<Test> getAllTestsbyUserId(int userId) {
        List<UserTest> userTests =  userTestRepository.getByUserUserId(userId);
        List<Test> testList = new ArrayList<Test>();
        for(UserTest userTest : userTests){
            testList.add(userTest.getTest());
        }
        return testList;
    }

    /**
     * @param userId
     * @param testId
     * @return
     */
    @Override
    public boolean isTestAttempted(int userId, int testId) {
        Optional<UserTest> userTest = userTestRepository.getByUserUserIdAndTestTestId(userId, testId);
        return userTest.isPresent();
    }

    /**
     * @param testId
     * @return
     */
    @Override
    public List<User> getStudentByTestId(int testId) {
        List<UserTest> userTests =  userTestRepository.getUserByTestTestId(testId);
        List<User> userList = new ArrayList<User>();
        for(UserTest userTest : userTests){
            userList.add(userTest.getUser());
        }
        return userList;
    }
}
