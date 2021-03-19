package com.example.onestopgrocery.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.onestopgrocery.entities.UserPayment;

import java.util.List;

@Dao
public interface UserPaymentDao {
    @Query("SELECT * FROM user_payments")
    List<UserPayment> getAll();

    @Query("SELECT * FROM user_payments WHERE user_id = :userId")
    UserPayment getByUserId(Long userId);

    @Query("SELECT * FROM user_payments WHERE payment_id = :paymentId")
    UserPayment getByPaymentId(Long paymentId);

    @Transaction
    @Update
    void update(UserPayment... userPayments);

    @Transaction
    @Insert
    void insert(UserPayment... userPayments);

    @Transaction
    @Delete
    void delete(UserPayment... userPayments);

    @Transaction
    @Query("DELETE FROM user_payments")
    void deleteAll();
}
