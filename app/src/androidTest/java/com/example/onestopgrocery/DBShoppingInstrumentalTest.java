package com.example.onestopgrocery;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.onestopgrocery.entities.Cart;
import com.example.onestopgrocery.entities.Payment;
import com.example.onestopgrocery.entities.PaymentType;
import com.example.onestopgrocery.entities.Product;
import com.example.onestopgrocery.entities.User;
import com.example.onestopgrocery.entities.enums.CardMethodType;
import com.example.onestopgrocery.models.CartAndOrders;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Database Order related Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class DBShoppingInstrumentalTest {

    Context appContext;
    AppDatabase db;
    User testUser1;
    User testUser2;
    User testUser3;
    Payment testPayment1;
    PaymentType testPaymentType1;
    PaymentType testPaymentType2;
    Product testProduct1;
    Product testProduct2;

    private User getInitTestUser(String index) {
        User user = new User();
        user.email = "test" + index + "@email.com";
        user.password = "test" + index + "Password";
        user.login = "test" + index + "Login";
        user.budget = 300d;
        user.city = "test" + index + "City";
        user.country = "test" + index + "Country";
        user.fullName = "test" + index + " user";
        user.logoResource = 123456;
        return user;
    }

    @Before
    public void init() {
        appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        db = AppDatabase.getDatabase(appContext);

        testUser1 = getInitTestUser("1");
        testUser2 = getInitTestUser("2");
        testUser3 = getInitTestUser("3");
        db.userDao().insert(testUser1, testUser2, testUser3);

        testPaymentType1 = new PaymentType("Debit Card",
                "Regular debit card with ability to pay online", CardMethodType.DEBIT_CARD.ordinal());
        testPaymentType2 = new PaymentType("Credit Card",
                "Regular credit card with ability to pay online", CardMethodType.CREDIT_CARD.ordinal());

        db.paymentTypeDao().insert(testPaymentType1, testPaymentType2);

        testPayment1 = new Payment("1111222233334444", "000",
                "Dummy User",  3, 21);

        testProduct1 = new Product("Apples", "Red apples from Mexico, 1 bag, 1kg", 3f, 4.30d, 1f, 10);
        testProduct2 = new Product("Cherry Tomatoes", "Tomatoes from Peru, 0.5kg", 4.2f, 2.15d, 0.5f, 21);
    }

    @After
    public void cleanUp() {
        db.userDao().deleteAll();
        db.paymentTypeDao().deleteAll();
        db.productDao().deleteAll();
    }

    @Test
    public void getAvailablePaymentTypes() {
        List<PaymentType> paymentTypeList = db.paymentTypeDao().getAll();
        assertEquals(paymentTypeList.size(), 2);
    }

    @Test
    public void insertMultipleProducts() {
        db.productDao().insert(testProduct1);
        db.productDao().insert(testProduct2);
        List<Product> productList = db.productDao().getAllProducts();
        assertEquals(productList.size(), 2);
    }

//    @Test
//    public void createCart() {
//        db.productDao().insert(testProduct1);
//        db.productDao().insert(testProduct2);
//        User user = db.userDao().findByEmail(testUser1.email);
//        List<Product> productList = db.productDao().getAll();
//        Cart cart = new Cart(user.id, new Date());
//    }
}