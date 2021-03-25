package com.example.onestopgrocery.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.onestopgrocery.entities.Product;
import com.example.onestopgrocery.repositories.GroceryRepository;

import java.util.List;

public class OneStopViewModel extends AndroidViewModel {

    GroceryRepository groceryRepository;
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
}
