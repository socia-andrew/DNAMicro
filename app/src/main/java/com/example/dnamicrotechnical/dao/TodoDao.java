package com.example.dnamicrotechnical.dao;



import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.dnamicrotechnical.model.Todo;

import java.util.List;

@Dao
public interface TodoDao {
    @Query("SELECT * FROM todo ORDER BY id")
    LiveData<List<Todo>> getAllTodo();

    @Insert
    void insertTodo(Todo todo);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateTodo(Todo todo);

    @Delete
    void deleteTodo(Todo todo);
}
