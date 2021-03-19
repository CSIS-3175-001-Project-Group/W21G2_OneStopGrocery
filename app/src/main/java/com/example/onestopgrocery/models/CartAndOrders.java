package com.example.onestopgrocery.models;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.onestopgrocery.entities.Cart;
import com.example.onestopgrocery.entities.Order;
import com.example.onestopgrocery.entities.Product;
import com.example.onestopgrocery.entities.User;

import java.util.ArrayList;
import java.util.List;

public class CartAndOrders {
    @Embedded
    public User user;
    @Relation(
            entity = Cart.class,
            parentColumn = "id",
            entityColumn = "user_id"
    )
    public Cart cart;
    @Relation(
            entity = Order.class,
            parentColumn = "id",
            entityColumn = "user_id"
    )
    public List<Order> orderList;

    public CartAndOrders() {
        this.orderList = new ArrayList<>();
    }
}
