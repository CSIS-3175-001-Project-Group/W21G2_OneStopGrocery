package com.example.onestopgrocery.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.onestopgrocery.entities.Cart;
import com.example.onestopgrocery.entities.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CartRepository {

    private MutableLiveData<List<Cart>> mutableCart = new MutableLiveData<>();

    public LiveData<List<Cart>> getCart() {
        if (mutableCart.getValue() == null) {
            initCart();
        }
        return mutableCart;
    }

    public void initCart() {
        mutableCart.setValue(new ArrayList<Cart>());
    }

    public boolean addProductToCart(Product product) {
        if (mutableCart.getValue() == null) {
            initCart();
        }

        List<Cart> cartList = new ArrayList<>(mutableCart.getValue());
        Cart cart = new Cart(Long.valueOf(1), product.getId(), product.getName(),
                product.getPrice(), product.getLogoResource(), 1, new Date());
        cartList.add(cart);
        mutableCart.setValue(cartList);
        return true;
    }
}
