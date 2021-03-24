package com.example.onestopgrocery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.onestopgrocery.helpers.Settings;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    List<Product> productList = new ArrayList<>();
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setLogo(R.mipmap.ic_launcher_round);

        addProduct(); // Populate the product list

        GridView productsGridView = findViewById(R.id.productsGridView);
        ProductAdapter productAdapter = new ProductAdapter(productList);
        productsGridView.setAdapter(productAdapter);

        productsGridView.setNumColumns(3);
        productsGridView.setHorizontalSpacing(8);
        productsGridView.setVerticalSpacing(8);

        productsGridView.setOnItemClickListener(
                (AdapterView<?> parent, View view, int position, long id) -> {

                    Intent productPageIntent = new Intent(HomeActivity.this, ProductActivity.class);
                    productPageIntent.putExtra("ProductInfo", productList.get(position));
                    startActivity(productPageIntent);
                }
        );
    }

    private void addProduct() {
        for(int i = 1; i <= 10; i++) {
            Product newProd = new Product(i, "TestProd " + i,
                    "Lorem Ipsum", R.drawable.placeholder);
            productList.add(newProd);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                Intent goSettings = new Intent(this, UserProfileActivity.class);
                startActivity(goSettings);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}