package com.example.onestopgrocery.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(indices = {@Index(value = { "user_id" }, unique = true)}, tableName = "carts")
public class Cart {
    @NonNull
    @PrimaryKey
    public Long id;
    @NonNull
    @ColumnInfo(name = "user_id")
    public Long userId;
    @NonNull
    @ColumnInfo(name = "created_datetime")
    public Date createdDatetime;

    public Cart(Long userId, Date createdDatetime) {
        this.userId = userId;
        this.createdDatetime = createdDatetime;
    }
}
