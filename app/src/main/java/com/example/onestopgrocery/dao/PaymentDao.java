package com.example.onestopgrocery.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Index;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.onestopgrocery.entities.Payment;

import java.util.List;

@Dao
public interface PaymentDao {
    @Query("SELECT * FROM payments")
    List<Payment> getAll();

    @Query("SELECT payments.* FROM payments " +
        "INNER JOIN user_payments " +
            "ON user_payments.payment_id = payments.id " +
            "WHERE user_payments.user_id = :userId")
    Payment getByUserId(Long userId);

    @Transaction
    @Update
    void update(Payment... payments);

    @Transaction
    @Insert
    void insert(Payment... payments);

    @Transaction
    @Delete
    void delete(Payment... payments);

    @Transaction
    @Query("DELETE FROM payments")
    void deleteAll();
}
