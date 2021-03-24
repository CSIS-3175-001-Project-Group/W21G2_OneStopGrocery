package com.example.onestopgrocery.entities;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
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
    @ColumnInfo(name = "logo_resource")
    public Integer logoResource;

    public Product(String name, String description, Float rating, Double price, Float weight, Integer logoResource) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.price = price;
        this.weight = weight;
        this.logoResource = logoResource;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Float getRating() {
        return rating;
    }

    public Double getPrice() {
        return price;
    }

    public Float getWeight() {
        return weight;
    }

    public Integer getLogoResource() {
        return logoResource;
    }
}
