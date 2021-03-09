package com.example.onestopgrocery.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.onestopgrocery.entities.User;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM users")
    List<User> getAll();

    @Query("SELECT * FROM users WHERE email = :userEmail")
    User findByEmail(String userEmail);

    @Query("SELECT * FROM users WHERE login = :userLogin")
    User findByLogin(String userLogin);

    @Insert
    void insertUser(User user);

    @Delete
    void delete(User user);
}
