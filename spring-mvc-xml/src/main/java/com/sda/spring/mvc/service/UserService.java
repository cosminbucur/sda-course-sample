package com.sda.spring.mvc.service;

import com.sda.spring.mvc.model.User;
import com.sda.spring.mvc.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public void create(User user) {
        userDao.create(user);
    }

    public User findOne(long id) {
        return userDao.findOne(id);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }
}
