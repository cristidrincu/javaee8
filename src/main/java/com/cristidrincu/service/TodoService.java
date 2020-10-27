package com.cristidrincu.service;

import com.cristidrincu.entity.Todo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class TodoService {

    @PersistenceContext(name = "todo-pu")
    EntityManager entityManager;

    public Todo create(Todo todo) {
        entityManager.persist(todo);
        return todo;
    }

    public Todo update(Todo todo) {
        todo.setCompleted(true);
        entityManager.merge(todo);
        return todo;
    }

    public List<Todo> getTodos() {
        return entityManager.createQuery("SELECT t from Todo t", Todo.class).getResultList();
    }

    public Todo find(Long todoId) {
        return entityManager.find(Todo.class, todoId);
    }
}
