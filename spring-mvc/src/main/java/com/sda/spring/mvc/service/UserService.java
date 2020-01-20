package com.sda.spring.mvc.service;

import com.sda.spring.mvc.dao.UserDao;
import com.sda.spring.mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    // TODO: create user dao
    @Autowired
    private UserDao userDao;

    // TODO: get list from the db
    @Transactional(readOnly = true)
    public List<User> list() {
        return userDao.list();
    }

    public void save(User user) {
        userDao.save(user);
    }
}
