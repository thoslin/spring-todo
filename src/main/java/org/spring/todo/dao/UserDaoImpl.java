package org.spring.todo.dao;


import org.spring.todo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int saveUser(User user) {
        String sql = "INSERT INTO users(username, password, enabled) VALUES (?, ?, ?)";
        return this.jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getEnabled());
    }
}
