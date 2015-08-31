package org.spring.todo.dao;

import org.spring.todo.model.Todo;

import java.util.List;

public interface TodoDao {
    int saveTodo(Todo todo);

    void deleteTodo(int id);

    Todo getTodoById(int id);

    List<Todo> getTodoList();
}