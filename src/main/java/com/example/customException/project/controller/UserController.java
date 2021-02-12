package com.example.customException.project.controller;

import com.example.customException.project.constant.UserImplConstants;
import com.example.customException.project.exception.UserNotFoundException;
import com.example.customException.project.model.User;
import com.example.customException.project.service.IUserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IUserManager userManager;

    @PostMapping(path = "/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User addedUser = userManager.addUser(user);
        return ResponseEntity.ok(addedUser);
    }

    @PostMapping(path = "/remove/{id}")
    public void removeUserById(@PathVariable int id){
         userManager.removeUserById(id);
    }

    @PostMapping(path = "/add/{id}")
    public void update(@RequestBody User user){
        userManager.updateUser(user);
    }

    @GetMapping(path = "/find/{id}")
    public User findById(@PathVariable int id){
        User findedUser = userManager.findById(id);
        if( findedUser == null)
            throw new UserNotFoundException(UserImplConstants.NO_USER_FOUND_BY_USERID + id);
        return findedUser;
    }




}
