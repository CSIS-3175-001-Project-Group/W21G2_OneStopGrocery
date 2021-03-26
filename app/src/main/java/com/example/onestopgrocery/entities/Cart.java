package com.example.onestopgrocery.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Date;
import java.util.Objects;

@Entity(indices = {@Index(value = { "id" })}, tableName = "cart")
public class Cart {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public Long id;
    @NonNull
    @ColumnInfo(name = "user_id")
    public Long userId;
    @NonNull
    @ColumnInfo(name = "product")
    public Product product;
    @NonNull
    @ColumnInfo(name = "quantity")
    public Integer quantity;
    @NonNull
    @ColumnInfo(name = "created_datetime")
    public Date createdDatetime;

    public Cart(@NonNull Long id, @NonNull Long userId, @NonNull Product product,
                @NonNull Integer quantity, @NonNull Date createdDatetime) {
        this.id = id;
        this.userId = userId;
        this.product = product;
        this.quantity = quantity;
        this.createdDatetime = createdDatetime;
    }

    @NonNull
    public Long getId() {
        return id;
    }

    @NonNull
    public Long getUserId() {
        return userId;
    }

    @NonNull
    public Product getProduct() {
        return product;
    }

    @NonNull
    public Integer getQuantity() {
        return quantity;
    }

    @NonNull
    public Date getCreatedDatetime() {
        return createdDatetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return getId().equals(cart.getId()) &&
                getUserId().equals(cart.getUserId()) &&
                getProduct().equals(cart.getProduct()) &&
                getQuantity().equals(cart.getQuantity()) &&
                getCreatedDatetime().equals(cart.getCreatedDatetime());
    }
}
