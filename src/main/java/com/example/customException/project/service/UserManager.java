package com.example.customException.project.service;

import com.example.customException.project.model.User;
import com.example.customException.project.repository.IUserDal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements IUserManager {

    @Autowired
    private IUserDal userDal;

    @Override
    public User addUser(User user) {
        return userDal.addUser(user);
    }

    @Override
    public void removeUserById(int id) {
        userDal.removeUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userDal.updateUser(user);
    }

    @Override
    public User findById(int id) {
        return userDal.findById(id);
    }
}
