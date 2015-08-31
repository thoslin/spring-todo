package org.spring.todo.dao;

import org.spring.todo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
        String sql = "INSERT INTO todo (id, description) VALUES (?, ?)";
        return jdbcTemplate.update(sql, todo.getId(), todo.getDescription());
    }

    //@Override
    public void deleteTodo(int id) {

    }

    //@Override
    public Todo getTodoById(int id) {
        return null;
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
}
