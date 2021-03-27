package com.example.onestopgrocery.entities;

import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Date;
import java.util.Objects;

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
    @ColumnInfo(name = "product_name")
    public String product_name;
    @NonNull
    @ColumnInfo(name = "product_price")
    public Double product_price;
    @ColumnInfo(name = "product_logo_resource")
    public Integer productLogoResource;
    @NonNull
    @ColumnInfo(name = "quantity")
    public Integer quantity;
    @NonNull
    @ColumnInfo(name = "created_datetime")
    public Date createdDatetime;

    public Cart(@NonNull Long userId, @NonNull Long product_id, @NonNull String product_name,
                @NonNull Double product_price, Integer productLogoResource,
                @NonNull Integer quantity, @NonNull Date createdDatetime) {
        this.userId = userId;
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.productLogoResource = productLogoResource;
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
    public Long getProduct_id() {
        return product_id;
    }

    @NonNull
    public String getProduct_name() {
        return product_name;
    }

    @NonNull
    public Double get_product_price() {
        return product_price;
    }

    public Integer getProductLogoResource() {
        return productLogoResource;
    }

    @NonNull
    public Integer getQuantity() {
        return quantity;
    }

    @NonNull
    public Date getCreatedDatetime() {
        return createdDatetime;
    }

    public void setQuantity(@NonNull Integer quantity) {
        this.quantity = quantity;
    }

    public static DiffUtil.ItemCallback<Cart> getItemCallback() {
        return itemCallback;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return
                getUserId().equals(cart.getUserId()) &&
                getProduct_id().equals(cart.getProduct_id()) &&
                getProduct_name().equals(cart.getProduct_name()) &&
                getProductLogoResource().equals(cart.getProductLogoResource()) &&
                get_product_price().equals(cart.get_product_price()) &&
                getQuantity().equals(cart.getQuantity()) &&
                getCreatedDatetime().equals(cart.getCreatedDatetime());
    }

    @BindingAdapter("android:setVal")
    public static void getSelectedSpinnerValue(Spinner spinner, int quantity) {
        spinner.setSelection(quantity - 1, true);
    }

    public static DiffUtil.ItemCallback<Cart> itemCallback = new DiffUtil.ItemCallback<Cart>() {
        @Override
        public boolean areItemsTheSame(@NonNull Cart oldItem, @NonNull Cart newItem) {
            return oldItem.getQuantity() == newItem.getQuantity();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Cart oldItem, @NonNull Cart newItem) {
            return oldItem.equals(newItem);
        }
    };
}
