package org.spring.todo.model;

import org.hibernate.validator.constraints.NotEmpty;


public class Todo {
    @NotEmpty(message="Description may not be empty")
    private String description;

    public Todo() {}

    public Todo(String description) {
        this.description = description;
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
                "description='" + description + '\'' +
                '}';
    }
}
