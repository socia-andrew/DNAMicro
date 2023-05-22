package com.example.dnamicrotechnical.model;


import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity(tableName = "todo")
public class Todo {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String todo;

    @Ignore
    public Todo(String todo) {
        this.todo = todo;
    }

    public Todo(int id, String todo) {
        this.id = id;
        this.todo = todo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }
}
