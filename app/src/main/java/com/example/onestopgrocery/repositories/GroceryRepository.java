package com.example.onestopgrocery.repositories;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.onestopgrocery.AppDatabase;
import com.example.onestopgrocery.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class GroceryRepository {

    private MutableLiveData<List<Product>> mutableProductList;
    private Application application;

    public GroceryRepository(Application application) {
        this.application = application;
    }

    public LiveData<List<Product>> getProducts() {
        if (mutableProductList == null) {
            mutableProductList = new MutableLiveData<>();
            loadProducts();
        }
        return mutableProductList;
    }

    private void loadProducts() {
        AppDatabase db = AppDatabase.getDatabase(application);
        List<Product> productList = db.productDao().getAllProducts();

        mutableProductList.setValue(productList);
    }
}
