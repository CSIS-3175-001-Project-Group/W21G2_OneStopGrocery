package com.example.onestopgrocery;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.onestopgrocery.dao.CartDao;
import com.example.onestopgrocery.dao.OrderDao;
import com.example.onestopgrocery.dao.PaymentTypeDao;
import com.example.onestopgrocery.dao.ProductDao;
import com.example.onestopgrocery.dao.UserDao;
import com.example.onestopgrocery.dao.UserPaymentDao;
import com.example.onestopgrocery.entities.Cart;
import com.example.onestopgrocery.entities.Order;
import com.example.onestopgrocery.entities.Payment;
import com.example.onestopgrocery.entities.PaymentType;
import com.example.onestopgrocery.entities.Product;
import com.example.onestopgrocery.entities.User;
import com.example.onestopgrocery.entities.UserPayment;
import com.example.onestopgrocery.entities.utils.Converters;

@Database(entities = { User.class, UserPayment.class, Product.class, Cart.class,
        Order.class, Payment.class, PaymentType.class }, version = 1)
@TypeConverters({Converters.class})
abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract ProductDao productDao();
    public abstract PaymentTypeDao paymentTypeDao();
    public abstract OrderDao orderDao();
    public abstract CartDao cartDao();
    public abstract UserPaymentDao userPaymentDao();
}

public class OneStopDatabase {
    public static final String DB_NAME = "onestop";
    private static AppDatabase instance;

    private OneStopDatabase() {}

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase.class, DB_NAME).fallbackToDestructiveMigration().build();
        }
        return instance;
    }
}
