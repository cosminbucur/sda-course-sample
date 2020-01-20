package com.sda.spring.mvc.dao;

import com.sda.spring.mvc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    // TODO: get users from db
    public List<User> list() {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<User> query = session.createQuery("from User");
        return query.getResultList();
    }

    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }
}
