package com.example.onestopgrocery;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.onestopgrocery.dao.UserDao;
import com.example.onestopgrocery.entities.User;

@Database(entities = {User.class}, version = 1)
abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}

public class OneStopDatabase {
    private static final String DB_NAME = "onestop";
    private static AppDatabase instance;

    private OneStopDatabase() {}

    public static AppDatabase getInstance(Context context) {
        if (instance != null) {
            return instance;
        } else {
            return Room.databaseBuilder(context, AppDatabase.class, DB_NAME).build();
        }
    }
}
