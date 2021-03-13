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
    public static final String DB_NAME = "onestop";
    private static AppDatabase instance;

    private OneStopDatabase() {}

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase.class, DB_NAME).fallbackToDestructiveMigration().build();
        }
        return instance;
    }
}
