package com.example.onestopgrocery.entities;


import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.bumptech.glide.Glide;

import java.util.Objects;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return getId().equals(product.getId()) &&
                getName().equals(product.getName()) &&
                getDescription().equals(product.getDescription()) &&
                getRating().equals(product.getRating()) &&
                getPrice().equals(product.getPrice()) &&
                getWeight().equals(product.getWeight()) &&
                getLogoResource().equals(product.getLogoResource());
    }

    public static DiffUtil.ItemCallback<Product> itemCallback = new DiffUtil.ItemCallback<Product>() {
        @Override
        public boolean areItemsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
            return oldItem.equals(newItem);
        }
    };

    @BindingAdapter("android:productImage")
    public static void loadImage(ImageView imageView, Integer image) {
        Glide.with(imageView).load(image).fitCenter().into(imageView);
    }
}
