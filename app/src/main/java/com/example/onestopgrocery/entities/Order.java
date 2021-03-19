package com.example.onestopgrocery.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.onestopgrocery.entities.enums.OrderStatus;

import java.util.Date;

@Entity(tableName = "orders")
public class Order {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "order_id")
    public Long id;
    @ColumnInfo(name = "product_id")
    public Long productId;
    @ColumnInfo(name = "ordered_qty")
    public Integer quantity;
    @ColumnInfo(name = "user_id")
    public Long userId;
    @ColumnInfo(name = "created_datetime")
    public Date createdDatetime;
    public Integer status;

    public Order() {}

    @Ignore
    public Order(Long productId, Integer quantity, Long userId, Date createdDatetime, OrderStatus status) {
        this.productId = productId;
        this.quantity = quantity;
        this.userId = userId;
        this.createdDatetime = createdDatetime;
        this.status = status.ordinal();
    }
}



