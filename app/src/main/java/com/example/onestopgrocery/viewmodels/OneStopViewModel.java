package com.example.onestopgrocery.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.onestopgrocery.entities.Cart;
import com.example.onestopgrocery.entities.Product;
import com.example.onestopgrocery.repositories.CartRepository;
import com.example.onestopgrocery.repositories.GroceryRepository;

import java.util.List;

public class OneStopViewModel extends AndroidViewModel {

    GroceryRepository groceryRepository;
    CartRepository cartRepository = new CartRepository();
    MutableLiveData<Product> mutableProduct = new MutableLiveData<>();

    public OneStopViewModel(Application application) {
        super(application);
        groceryRepository = new GroceryRepository(application);

    }

    public LiveData<List<Product>> getProducts() {
        return groceryRepository.getProducts();
    }

    public void setProduct(Product product) {
        mutableProduct.setValue(product);
    }

    public LiveData<Product> getProduct() {
        return mutableProduct;
    }

    public LiveData<List<Cart>> getCart() { return cartRepository.getCart(); }

    public boolean addProductToCart(Product product) {
        return cartRepository.addProductToCart(product);
    }

    public void removeProductFromCart(Cart cart) {
        cartRepository.removeProductFromCart(cart);
    }

    public void changeProductQuantity(Cart cart, int quantity) {
        cartRepository.changeProductQuantity(cart, quantity);
    }

    public LiveData<Double> getTotalPrice() {
        return cartRepository.getTotalPrice();
    }
}
