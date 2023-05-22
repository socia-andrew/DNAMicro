package com.example.dnamicrotechnical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.widget.Button;

import com.example.dnamicrotechnical.dao.TodoDB;
import com.example.dnamicrotechnical.model.Todo;
import com.example.dnamicrotechnical.viewmodel.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements TodoAdapter.ItemClickListener {


    private RecyclerView rvTodoList;
    private Button btnSaveTodo;
    private AppCompatEditText edTodo;
    private MainActivityViewModel mainViewModel;

    private TodoAdapter mAdapter;
    private TodoDB todoDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mainViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        todoDB = TodoDB.getInstance(getApplicationContext());
        rvTodoList = findViewById(R.id.rv_todo);
        btnSaveTodo = findViewById(R.id.btn_todo);
        edTodo = findViewById(R.id.ed_todo);

        rvTodoList.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration decoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        rvTodoList.addItemDecoration(decoration);

        mAdapter = new TodoAdapter(this, this);
        rvTodoList.setAdapter(mAdapter);
        mainViewModel.getTodo().observe(this, todos -> {
            mAdapter.setTodos(todos);
        });

        btnSaveTodo.setOnClickListener(v -> {
            if (edTodo.getText().toString() != "") {
                Todo todo = new Todo(edTodo.getText().toString());
                mainViewModel.insertTodo(todo);
               // mainViewModel.getTodoList();

            }
        });


    }

    @Override
    public void onItemClickListener(int itemId) {

    }
}