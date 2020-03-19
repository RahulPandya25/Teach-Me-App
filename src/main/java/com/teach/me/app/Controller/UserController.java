package com.teach.me.app.Controller;

import com.teach.me.app.Exception.UserNotFoundException;
import com.teach.me.app.Model.User;
import com.teach.me.app.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/insert")
    private void insertUser(@RequestBody User user){
        userService.insertUser(user);
    }
    @GetMapping("/all")
    private List<User> getAllUser(){
        List<User> userList = new ArrayList<User>();
        userList = userService.getAllUsers();
        return  userList;
    }
    @GetMapping("/{userId}")
    private User getUserById(@PathVariable int userId) throws UserNotFoundException {
        return userService.getUserById(userId);
    }
}
