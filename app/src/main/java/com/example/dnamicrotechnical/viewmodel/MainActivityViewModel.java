package com.example.dnamicrotechnical.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.dnamicrotechnical.dao.TodoDB;
import com.example.dnamicrotechnical.model.Todo;
import com.example.dnamicrotechnical.repository.TodoRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private LiveData<List<Todo>> todo;
    private final TodoRepository todoRepository;

    public MainActivityViewModel(Application application) {
        super(application);
        TodoDB todoDB = TodoDB.getInstance(this.getApplication());
        todoRepository = new TodoRepository(todoDB);
        todo = todoRepository.getAllTodo();
    }

    public LiveData<List<Todo>> getTodo() {
        return todo;
    }

    public LiveData<List<Todo>> getTodoList() {
        todo = todoRepository.getAllTodo();
        return todo;
    }



    public void deleteTask(Todo todo) {
        todoRepository.deleteTodoItem(todo);
    }

    public void insertTodo(Todo todo) {
        todoRepository.saveToDoItem(todo);
    }
}
