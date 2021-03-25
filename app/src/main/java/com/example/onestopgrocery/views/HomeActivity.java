package com.example.onestopgrocery.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;


import com.example.onestopgrocery.AppDatabase;
import com.example.onestopgrocery.ProductActivity;
import com.example.onestopgrocery.ProductAdapter;
import com.example.onestopgrocery.R;
import com.example.onestopgrocery.UserProfileActivity;
import com.example.onestopgrocery.helpers.Settings;

import java.util.List;

import com.example.onestopgrocery.dao.ProductDao;
import com.example.onestopgrocery.entities.Product;


public class HomeActivity extends AppCompatActivity {
//    Toolbar toolbar;
    NavController navController;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        navController = Navigation.findNavController(this, R.id.navHostFragment);
        NavigationUI.setupActionBarWithNavController(this, navController);
//        toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
        if (getIntent().hasExtra(Settings.USER_LOGGED_KEY)) {
            try {
                boolean userLoggedIn = getIntent().getBooleanExtra(Settings.USER_LOGGED_KEY, true);
                Settings.getSettings(this).edit().putBoolean(Settings.USER_LOGGED_KEY, userLoggedIn).commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (getIntent().hasExtra(Settings.USER_INFO)) {
            try {
              String rawInfo = getIntent().getStringExtra(Settings.USER_INFO);
              Settings.getSettings(this).edit().putString(Settings.USER_INFO, rawInfo).commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        navController.navigateUp();
        return super.onSupportNavigateUp();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return NavigationUI.onNavDestinationSelected(item, navController) ||
        super.onOptionsItemSelected(item);
    }
}