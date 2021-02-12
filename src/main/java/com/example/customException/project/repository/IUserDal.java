package com.example.customException.project.repository;

import com.example.customException.project.model.User;

public interface IUserDal {

    User addUser(User user);

    void removeUserById(int id);

    void updateUser(User user);

    User findById(int id);
}
