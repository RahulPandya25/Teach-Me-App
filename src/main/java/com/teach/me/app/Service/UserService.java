package com.teach.me.app.Service;

import com.teach.me.app.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    /**
     *
     * @param user
     */
    public void insertUser(User user);

    /**
     *
     * @return
     */
    public List<User> getAllUsers();

    /**
     *
     * @param id
     * @return
     */
    public Optional<User> getUserById(int id);
}
