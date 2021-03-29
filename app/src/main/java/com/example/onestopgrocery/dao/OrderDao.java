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

    @Query("SELECT * FROM orders WHERE user_id = :userId")
    List<Order> getByUserId(Long userId);

    @Transaction
    @Query("UPDATE orders SET shipping_address = :shippingAddress WHERE user_id = :userId")
    void updateShippingAdd(Long userId, String shippingAddress);

    @Transaction
    @Query("UPDATE orders SET product_total = :productTotal, tax_amount = :productTotal * 0.05, " +
            "shipping_price = CASE WHEN :productTotal >= 50.0 THEN 0.0 ELSE 5.00 END " +
            ", total_price = :productTotal + tax_amount + shipping_price WHERE user_id = :userId")
    void updateProductTotal(Long userId, Double productTotal);

    @Transaction
    @Query("UPDATE orders SET total_price = product_total + tax_amount + shipping_price")
    void updateTotalPrice();

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
