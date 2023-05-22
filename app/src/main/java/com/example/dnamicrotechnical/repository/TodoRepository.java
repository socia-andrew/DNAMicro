package com.example.dnamicrotechnical.repository;



import androidx.lifecycle.LiveData;

import com.example.dnamicrotechnical.dao.TodoDB;
import com.example.dnamicrotechnical.model.Todo;

import java.util.List;

public class TodoRepository {


    private LiveData<List<Todo>> todos;
    private TodoDB todoDB;

    public TodoRepository(TodoDB database) {
        this.todoDB = database;
    }



    public LiveData<List<Todo>> getAllTodo() {
        todos = todoDB.todoDao().getAllTodo();
        return todos;
    }

    public void deleteTodoItem(Todo todo) {
        todoDB.todoDao().deleteTodo(todo);
    }

    public void updateTodo(Todo todo) {
        todoDB.todoDao().deleteTodo(todo);
    }

    public void saveToDoItem(Todo todo) {
        todoDB.todoDao().insertTodo(todo);
    }

}
