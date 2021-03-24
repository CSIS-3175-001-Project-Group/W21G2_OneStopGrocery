package com.example.onestopgrocery.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.onestopgrocery.entities.Product;

import java.util.List;

@Dao
public interface ProductDao {
    @Query("SELECT * FROM products")
    List<Product> getAllProducts();

    @Query("SELECT * FROM products WHERE name = :productName")
    Product findByName(String productName);

    @Query("SELECT * FROM products WHERE rating = :rating")
    List<Product> findByRating(Float rating);

    @Query("SELECT * FROM products WHERE id = :id")
    Product findById(Long id);

    @Transaction
    @Update
    void update(Product... products);

    @Transaction
    @Insert
    void insert(Product... products);

    @Transaction
    @Delete
    void delete(Product... products);

    @Transaction
    @Query("DELETE FROM products")
    void deleteAll();
}
