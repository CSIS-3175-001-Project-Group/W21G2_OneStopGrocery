package com.example.onestopgrocery.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(indices = {@Index(value = { "id" })}, tableName = "carts")
public class Cart {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public Long id;
    @NonNull
    @ColumnInfo(name = "user_id")
    public Long userId;
    @NonNull
    @ColumnInfo(name = "product_id")
    public Long product_id;
    @NonNull
    @ColumnInfo(name = "quantity")
    public Integer quantity;
    @NonNull
    @ColumnInfo(name = "created_datetime")
    public Date createdDatetime;


    public Cart(@NonNull Long userId, @NonNull Long product_id,
                @NonNull Integer quantity, @NonNull Date createdDatetime) {
        this.userId = userId;
        this.product_id = product_id;
        this.quantity = quantity;
        this.createdDatetime = createdDatetime;
    }
}
