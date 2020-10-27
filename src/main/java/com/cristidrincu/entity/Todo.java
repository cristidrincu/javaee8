package com.cristidrincu.entity;

import java.io.Serializable;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class Todo implements Serializable {

    @NotEmpty(message = "Task must be set")
    @Size(min = 10, message = "Task should not be less than 10 characters")
    private String task;

    @NotNull(message = "Due date must be set")
    @FutureOrPresent(message = "Due date must be in the present or future")
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDate dueDate;


    private boolean isCompleted;
    private LocalDate dateCompleted;
    private LocalDate dateCreated;
    private Long todo_id;

    @PrePersist //lifecycle callback method - gets called just before the entity gets persisted in the db
    private void init() {
        setDateCreated(LocalDate.now());
    }

    public void setTodo_id(Long todo_id) {
        this.todo_id = todo_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getTodo_id() {
        return todo_id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public LocalDate getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(LocalDate dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }
}
