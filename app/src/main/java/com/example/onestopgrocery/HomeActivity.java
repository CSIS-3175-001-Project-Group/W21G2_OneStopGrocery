package com.example.onestopgrocery;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    List<Product> productList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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

    }

    private void addProduct() {
        for(int i = 1; i <= 10; i++) {
            Product newProd = new Product(i, "TestProd " + i,
                    "Lorem Ipsum", R.drawable.placeholder);
            productList.add(newProd);
        }
    }
}