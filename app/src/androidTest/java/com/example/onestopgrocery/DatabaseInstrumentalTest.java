package com.example.onestopgrocery;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.onestopgrocery.entities.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Database Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class DatabaseInstrumentalTest {

    Context appContext;
    AppDatabase db;
    User testUser1;
    User testUser2;
    User testUser3;

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
        db = OneStopDatabase.getInstance(appContext);
        testUser1 = getInitTestUser("1");
        testUser2 = getInitTestUser("2");
        testUser3 = getInitTestUser("3");
    }

    @After
    public void cleanUp() {
        db.userDao().deleteAll();
    }

    @Test
    public void insertOneUserAndGetOne() {
        db.userDao().insertUser(testUser1);
        List<User> userList = db.userDao().getAll();
        assertEquals(userList.size(), 1);
    }

    @Test
    public void insertThreeAndGetThree() {
        db.userDao().insertUser(testUser1);
        db.userDao().insertUser(testUser2);
        db.userDao().insertUser(testUser3);
        List<User> userList = db.userDao().getAll();
        assertEquals(userList.size(), 3);
    }

    @Test
    public void getInsertedUserByEmail() {
        db.userDao().insertUser(testUser1);
        db.userDao().insertUser(testUser2);
        db.userDao().insertUser(testUser3);
        User user = db.userDao().findByEmail(testUser1.email);
        assertNotEquals(user, null);
        assertEquals(user.email, testUser1.email);
    }

    @Test
    public void getInsertedUserByLogin() {
        db.userDao().insertUser(testUser1);
        db.userDao().insertUser(testUser2);
        db.userDao().insertUser(testUser3);
        User user = db.userDao().findByLogin(testUser1.login);
        assertNotEquals(user, null);
        assertEquals(user.login, testUser1.login);
    }

    @Test
    public void deleteUser() {
        db.userDao().insertUser(testUser1);
        db.userDao().insertUser(testUser2);
        db.userDao().insertUser(testUser3);
        db.userDao().delete(testUser2);
        User user = db.userDao().findByEmail(testUser2.email);
        assertEquals(user, null);
    }
}