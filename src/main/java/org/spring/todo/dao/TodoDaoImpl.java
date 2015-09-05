package org.spring.todo.dao;

import org.spring.todo.model.Todo;
import org.spring.todo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class TodoDaoImpl implements TodoDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //@Override
    public int saveTodo(Todo todo) {
        String sql = "INSERT INTO todo (id, description, username) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, todo.getId(), todo.getDescription(), todo.getUser().getUsername());
    }

    //@Override
    public void deleteTodo(int id) {
        String sql = "DELETE FROM todo WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    //@Override
    public List<Todo> getTodoList() {
        String sql = "SELECT * FROM todo";

        return jdbcTemplate.query(sql, new RowMapper<Todo>() {
            public Todo mapRow(ResultSet resultSet, int i) throws SQLException {
                Todo todo = new Todo();

                todo.setId(resultSet.getInt("id"));
                todo.setDescription(resultSet.getString("description"));

                return todo;
            }
        });
    }

    public List<Todo> getTodoListByUser(UserDetails user) {
        String sql = "SELECT * FROM todo WHERE username=?";
        return jdbcTemplate.query(sql, new Object[]{user.getUsername()}, new RowMapper<Todo>() {
            public Todo mapRow(ResultSet resultSet, int i) throws SQLException {
                Todo todo = new Todo();

                todo.setId(resultSet.getInt("id"));
                todo.setDescription(resultSet.getString("description"));
                return todo;
            }
        });
    }
}
