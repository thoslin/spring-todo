package org.spring.todo.dao;

import org.spring.todo.model.User;

public interface UserDao {
    int saveUser(User user);
}
