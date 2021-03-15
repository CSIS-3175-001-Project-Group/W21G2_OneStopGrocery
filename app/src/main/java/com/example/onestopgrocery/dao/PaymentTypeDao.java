package com.example.onestopgrocery.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.onestopgrocery.entities.PaymentType;

import java.util.List;

@Dao
public interface PaymentTypeDao {
    @Query("SELECT * FROM payment_types")
    List<PaymentType> getAll();

    @Query("SELECT * FROM payment_types WHERE type = :paymentType")
    PaymentType getByType(Integer paymentType);

    @Query("SELECT * FROM payment_types WHERE name = :paymentName")
    PaymentType getByName(String paymentName);

    @Transaction
    @Update
    void update(PaymentType... payments);

    @Transaction
    @Insert
    void insert(PaymentType... payments);

    @Transaction
    @Delete
    void delete(PaymentType... payments);

    @Transaction
    @Query("DELETE FROM payment_types")
    void deleteAll();

}
