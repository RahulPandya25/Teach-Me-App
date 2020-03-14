package com.teach.me.app.Repository;

import com.teach.me.app.Model.Test;
import com.teach.me.app.Model.UserTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTestRepository extends JpaRepository<UserTest, Integer> {

    public List<Test> getAllByTestUserEquals(int userId);
}
