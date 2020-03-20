package com.teach.me.app.Controller;

import com.teach.me.app.Model.Test;
import com.teach.me.app.Model.User;
import com.teach.me.app.Service.UserTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserTestController {
    @Autowired
    private UserTestService userTestService;

    @GetMapping("/test/students/{testId}")
    private List<User> getStudentByTestId(@PathVariable int testId){
        List<User> user = new ArrayList<User>();
        user = userTestService.getStudentByTestId(testId);
        return user;
    }

    @GetMapping("/students/test/{userId}")
    private List<Test> getTestByStudent(@PathVariable int userId){
        List<Test> testList = new ArrayList<Test>();
        testList = userTestService.getAllTestsbyUserId(userId);
        return testList;
    }

    @GetMapping("/students/test/{testId}/{userId}")
    private boolean isTestAttempted(@PathVariable int testId, @PathVariable int userId){
        return userTestService.isTestAttempted(userId, testId);
    }


}