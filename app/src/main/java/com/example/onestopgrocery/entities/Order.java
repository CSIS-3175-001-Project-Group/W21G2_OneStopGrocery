package com.example.onestopgrocery.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.onestopgrocery.entities.enums.OrderStatus;

import java.util.Date;

@Entity(tableName = "orders")
public class Order {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "order_id")
    public Long id;
    @NonNull
    @ColumnInfo(name = "user_id")
    public Long userId;

    @ColumnInfo(name = "shipping_address")
    public String shippingAddress;

    @ColumnInfo(name = "product_total")
    public Double productTotal;

    @ColumnInfo(name = "shipping_price")
    public Double shippingPrice;

    @ColumnInfo(name = "tax_amount")
    public Double taxAmount;

    @ColumnInfo(name = "total_price")
    public Double totalPrice;

    @ColumnInfo(name = "created_datetime")
    public Date createdDatetime;

    public Order(@NonNull Long userId, Double productTotal) {
        this.userId = userId;
        this.productTotal = productTotal;
    }

    @NonNull
    public Long getId() {
        return id;
    }

    @NonNull
    public Long getUserId() {
        return userId;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public Double getProductTotal() {
        return productTotal;
    }

    public Double getShippingPrice() {
        return shippingPrice;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

}



