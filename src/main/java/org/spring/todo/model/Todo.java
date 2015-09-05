package org.spring.todo.model;

import org.hibernate.validator.constraints.NotEmpty;


public class Todo {
    private int id;
    @NotEmpty(message="Description may not be empty")
    private String description;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Todo() {}

    public Todo(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
