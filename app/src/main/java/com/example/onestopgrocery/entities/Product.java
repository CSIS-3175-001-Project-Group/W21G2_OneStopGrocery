package com.example.onestopgrocery.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "products")
public class Product {
    @PrimaryKey(autoGenerate = true)
    public Long id;
    public String name;
    public String description;
    public Float rating;
    public Double price;
    public Float weight;
    public Integer quantity;
    @ColumnInfo(name = "logo_resource")
    public Integer logoResource;

    public Product(String name, String description, Float rating, Double price, Float weight, Integer quantity, Integer logoResource) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.price = price;
        this.weight = weight;
        this.quantity = quantity;
        this.logoResource = logoResource;
    }
}
