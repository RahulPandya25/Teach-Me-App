package com.teach.me.app.ServiceImpl;

import com.teach.me.app.Model.Test;
import com.teach.me.app.Repository.UserRepository;
import com.teach.me.app.Repository.UserTestRepository;
import com.teach.me.app.Service.UserTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
        return userTestRepository.getAllByTestUserEquals(userId);
    }
}
