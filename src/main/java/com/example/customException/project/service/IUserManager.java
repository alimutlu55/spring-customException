package com.example.customException.project.service;

import com.example.customException.project.model.User;

public interface IUserManager {

    User addUser(User user);

    void removeUserById(int id);

    void updateUser(User user);

    User findById(int id);
}
