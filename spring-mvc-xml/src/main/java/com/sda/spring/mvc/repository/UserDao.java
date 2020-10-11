package com.sda.spring.mvc.repository;

import com.sda.spring.mvc.model.User;

import java.util.List;

public interface UserDao {

    User findOne(long id);

    List<User> findAll();

    void create(User user);

    User update(User user);

    void delete(User user);

    void deleteById(long id);
}
