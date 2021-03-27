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
    private MutableLiveData<Double> mutableTotalPrice = new MutableLiveData<>();

    public LiveData<List<Cart>> getCart() {
        if (mutableCart.getValue() == null) {
            initCart();
        }
        return mutableCart;
    }

    public void initCart() {
        mutableCart.setValue(new ArrayList<Cart>());
        calculateCartTotal();
    }

    public boolean addProductToCart(Product product) {
        if (mutableCart.getValue() == null) {
            initCart();
        }

        List<Cart> cartList = new ArrayList<>(mutableCart.getValue());
        for (Cart cart: cartList) {
            if (cart.getProduct_id().equals(product.getId())) {
                if (cart.getQuantity() == 5) {
                    return false;
                }
                int index = cartList.indexOf(cart);
                cart.setQuantity(cart.getQuantity() + 1);
                cartList.set(index, cart);
                mutableCart.setValue(cartList);
                calculateCartTotal();
                return true;
            }
        }

        Cart cart = new Cart(Long.valueOf(1), product.getId(), product.getName(),
                product.getPrice(), product.getLogoResource(), 1, new Date());
        cartList.add(cart);
        mutableCart.setValue(cartList);
        calculateCartTotal();
        return true;
    }

    public void removeProductFromCart(Cart cart) {
        if (mutableCart.getValue() == null) {
            return;
        }

        List<Cart> cartList = new ArrayList<>(mutableCart.getValue());
        cartList.remove(cart);
        mutableCart.setValue(cartList);
        calculateCartTotal();
    }

    public void changeProductQuantity(Cart cart, int quantity) {
        if (mutableCart.getValue() == null) {
            return;
        }

        List<Cart> cartList = new ArrayList<>(mutableCart.getValue());
        Cart updatedProduct = new Cart(cart.getUserId(), cart.getProduct_id(),
                cart.getProduct_name(), cart.get_product_price(), cart.getProductLogoResource(),
                quantity, cart.getCreatedDatetime());
        cartList.set(cartList.indexOf(cart), updatedProduct);
        mutableCart.setValue(cartList);
        calculateCartTotal();
    }

    private void calculateCartTotal() {
        if (mutableCart.getValue() == null) {
            return;
        }
        double total = 0.0;
        List<Cart> cartList = mutableCart.getValue();
        for (Cart cart: cartList) {
            total += cart.get_product_price() * cart.getQuantity();
        }
        mutableTotalPrice.setValue(total);
    }

    public LiveData<Double> getTotalPrice() {
        if (mutableTotalPrice.getValue() == null) {
            mutableTotalPrice.setValue(0.0);
        }
        return mutableTotalPrice;
    }
}
