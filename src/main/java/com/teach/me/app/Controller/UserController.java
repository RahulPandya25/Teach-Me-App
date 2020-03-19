package com.teach.me.app.Controller;

import com.teach.me.app.Model.User;
import com.teach.me.app.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private List getAllUser(){
        return userService.getAllUsers();
    }
    @GetMapping("/{userId}")
    private Optional<User> getUserById(@PathVariable int userId){
        return userService.getUserById(userId);
    }
}
