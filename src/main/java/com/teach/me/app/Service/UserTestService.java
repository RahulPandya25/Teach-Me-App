package com.teach.me.app.Service;

import com.teach.me.app.Model.Test;
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
}
