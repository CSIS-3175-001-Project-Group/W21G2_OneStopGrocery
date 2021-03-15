package com.example.onestopgrocery.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.example.onestopgrocery.entities.enums.CardMethodType;

@Entity(indices = {@Index(value = { "name", "type" }, unique = true)},
        tableName = "payment_types")
public class PaymentType {
    @PrimaryKey(autoGenerate = true)
    public Long id;
    @NonNull
    public String name;
    @NonNull
    public String description;
    @NonNull
    public int type;

    public PaymentType() {}

    @Ignore
    public PaymentType(String name, String description, Integer methodType) {
        this.name = name;
        this.description = description;
        this.type = methodType;
    }
}