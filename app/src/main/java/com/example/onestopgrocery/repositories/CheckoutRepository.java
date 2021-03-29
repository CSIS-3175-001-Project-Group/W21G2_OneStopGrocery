package com.example.onestopgrocery.repositories;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.onestopgrocery.AppDatabase;
import com.example.onestopgrocery.dao.OrderDao;
import com.example.onestopgrocery.entities.Order;

import java.util.List;

public class CheckoutRepository {

    private static final String TAG = "CheckoutRepository";
    private MutableLiveData<Order> mutableOrder = new MutableLiveData<>();
    private OrderDao orderDao;
    Application application;
    AppDatabase db;

    public CheckoutRepository(Application application) {
        this.application = application;
        db = AppDatabase.getDatabase(application);
        orderDao = db.orderDao();
    }

    public List<Order> fetchOrder(Long userId) {
        List<Order> orderList = orderDao.getByUserId(userId);
        return orderList;
    }
}
