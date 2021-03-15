package com.example.onestopgrocery.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.onestopgrocery.entities.Cart;
import com.example.onestopgrocery.models.CartAndOrders;

import java.util.List;

@Dao
public interface CartDao {
    @Query("SELECT * FROM carts")
    List<Cart> getAll();

    @Query("SELECT * FROM carts WHERE user_id = :userId")
    Cart getByUserId(Long userId);

    @Query("SELECT * FROM carts WHERE user_id = :userId")
    CartAndOrders getCartAndOrdersPerUserId(Long userId);

    @Transaction
    @Update
    void update(Cart... carts);

    @Transaction
    @Insert
    void insert(Cart... carts);

    @Transaction
    @Delete
    void delete(Cart... carts);

    @Transaction
    @Query("DELETE FROM carts")
    void deleteAll();
}
