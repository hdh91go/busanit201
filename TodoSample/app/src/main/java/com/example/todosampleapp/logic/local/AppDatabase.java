package com.example.todosampleapp.logic.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.todolist.model.Item;
import com.example.todosampleapp.model.LoginItem;

@Database(entities = {LoginItem.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ItemDao getItemDao();
}
