package org.spring.todo.dao;

import org.spring.todo.model.Todo;
import org.spring.todo.model.User;

import java.util.List;

public interface TodoDao {
    int saveTodo(Todo todo);

    void deleteTodo(int id);

    List<Todo> getTodoList();

    List<Todo> getTodoListByUser(User user);
}