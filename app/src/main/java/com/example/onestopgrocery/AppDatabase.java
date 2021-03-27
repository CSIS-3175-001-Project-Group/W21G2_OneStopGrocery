package com.example.onestopgrocery;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

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
import com.example.onestopgrocery.initdata.PaymentTypeData;
import com.example.onestopgrocery.initdata.ProductData;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = { User.class, UserPayment.class, Product.class, Cart.class,
        Order.class, Payment.class, PaymentType.class }, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();
    public abstract ProductDao productDao();
    public abstract PaymentTypeDao paymentTypeDao();
    public abstract OrderDao orderDao();
    public abstract CartDao cartDao();
    public abstract UserPaymentDao userPaymentDao();

    private static volatile AppDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "one_stop_database")
                            .addCallback(sRoomDatabaseCallback)
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(() -> {
                INSTANCE.paymentTypeDao().deleteAll();
                PaymentTypeData paymentTypeList = new PaymentTypeData();
                for (PaymentType paymentType : paymentTypeList.getData()) {
                    INSTANCE.paymentTypeDao().insert(paymentType);
                }

                INSTANCE.productDao().deleteAll();
                ProductData productData = new ProductData();
                productData.init();
                for (Product product : productData.getData()) {
                    INSTANCE.productDao().insert(product);
                }
            });
        }
    };
}


