package com.example.dnamicrotechnical.dao;



import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.dnamicrotechnical.model.Todo;

@Database(entities = {Todo.class}, version = 1, exportSchema = false)
public abstract class TodoDB extends RoomDatabase {

    private static final String LOG_TAG = TodoDB.class
            .getSimpleName();
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "todolist";
    private static TodoDB sInstance;


    public static TodoDB getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = Room.databaseBuilder(context
                                        .getApplicationContext(),
                                TodoDB.class, TodoDB.DATABASE_NAME).allowMainThreadQueries()
                        .build();
            }
        }
        return sInstance;
    }

    public abstract TodoDao todoDao();

}