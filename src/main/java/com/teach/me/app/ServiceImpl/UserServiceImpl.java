package com.teach.me.app.ServiceImpl;

import com.teach.me.app.Exception.UserNotFoundException;
import com.teach.me.app.Model.User;
import com.teach.me.app.Repository.UserRepository;
import com.teach.me.app.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    /**
     * @param user
     */
    @Override
    public User insertUser(User user) {
        return userRepository.save(user);
    }

    /**
     * @return
     */
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * @param userId
     * @return
     */
    @Override
    public User getUserById(int userId) throws UserNotFoundException {
        return userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
    }
}
