package com.example.onestopgrocery.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.onestopgrocery.entities.Order;

import java.util.List;

@Dao
public interface OrderDao {
    @Query("SELECT * FROM orders")
    List<Order> getAll();

    @Query("SELECT * FROM orders WHERE status = :orderStatus")
    List<Order> getByStatus(Short orderStatus);

    @Query("SELECT * FROM orders WHERE user_id = :userId")
    List<Order> getByUserId(Long userId);

    @Query("SELECT * FROM orders WHERE user_id = :userId AND status = :orderStatus")
    List<Order> getByUserAndStatus(Long userId, Short orderStatus);

    @Transaction
    @Update
    void update(Order... orders);

    @Transaction
    @Insert
    void insert(Order... orders);

    @Transaction
    @Delete
    void delete(Order... orders);

    @Transaction
    @Query("DELETE FROM orders")
    void deleteAll();
}
