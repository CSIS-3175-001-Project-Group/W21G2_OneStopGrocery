package com.example.onestopgrocery.repositories;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.onestopgrocery.AppDatabase;
import com.example.onestopgrocery.dao.OrderDao;
import com.example.onestopgrocery.entities.Order;

import java.util.Date;
import java.util.List;

public class OrderRepository {

    private static final String TAG = "OrderRepository";
    private MutableLiveData<Order> mutableOrder = new MutableLiveData<>();
    private OrderDao orderDao;
    Application application;
    AppDatabase db;


    public OrderRepository(Application application) {
        this.application = application;
        db = AppDatabase.getDatabase(application);
        orderDao = db.orderDao();
    }

    public void saveOrder(Double productTotal) {
        List<Order> currOrder = orderDao.getByUserId(Long.valueOf(1));
        if (currOrder.isEmpty()) {
            orderDao.insert(new Order(Long.valueOf(1), productTotal));
        } else {
            orderDao.updateProductTotal(Long.valueOf(1), productTotal);
        }
        orderDao.updateTotalPrice();
    }

    public void updateShippingAdd(Long userId, String shippingAddress) {
        orderDao.updateShippingAdd(userId, shippingAddress);
    }
}
