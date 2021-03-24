package com.example.onestopgrocery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.onestopgrocery.dao.CartDao;
import com.example.onestopgrocery.dao.ProductDao;
import com.example.onestopgrocery.entities.Cart;
import com.example.onestopgrocery.entities.Product;
import com.example.onestopgrocery.entities.User;
import com.example.onestopgrocery.helpers.Settings;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductActivity extends AppCompatActivity {
    private ProductDao productDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        AppDatabase db = AppDatabase.getDatabase(getApplication());
        productDao = db.productDao();

        Intent productPageIntent = getIntent();
        Long prodId = productPageIntent.getLongExtra("ProductId", 0);
        Product selectedProduct = productDao.findById(prodId);

        TextView prodTxtViewTitle = findViewById(R.id.prodTxtViewTitle);
        ImageView imgViewSelectedProd = findViewById(R.id.imgViewSelectedProd);
        TextView prodTxtViewDesc = findViewById(R.id.prodTxtViewDesc);
        Button btnAddToCart = findViewById(R.id.btnAddToCart);

        prodTxtViewTitle.setText(selectedProduct.getName());
        imgViewSelectedProd.setImageResource(selectedProduct.getLogoResource());
        prodTxtViewDesc.setText(selectedProduct.getDescription());

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Date date = new Date(System.currentTimeMillis());
                            CartDao cartDao = db.cartDao();
                            User user = Settings.getLoggedUserData(getApplicationContext());
                            Cart cartItem = new Cart(Long.valueOf(123), selectedProduct.getId(),
                                    1, date);
                            cartDao.insert(cartItem);
                            Log.d("One Stop", "Added product " + selectedProduct.getId()
                                    + " to cart");
                        } catch (Exception ex) {
                            Log.d("One Stop", "Error adding item to cart " +
                                    ex.getMessage());
                        }

                    }
                }).start();
            }
        });


    }
}