package com.example.onestopgrocery.entities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        indices = {
        @Index(value = { "user_id" }, unique = true),
        @Index(value = { "payment_id" }, unique = true)
    }, tableName = "user_payments")
public class UserPayment {
    @Nullable
    @ColumnInfo(name = "payment_id")
    public Long paymentId;
    @PrimaryKey
    @ColumnInfo(name = "user_id")
    public Long userId;

    public UserPayment(Long userId, Long paymentId) {
        this.userId = userId;
        this.paymentId = paymentId;
    }
}
