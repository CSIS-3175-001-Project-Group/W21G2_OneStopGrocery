package com.example.onestopgrocery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        Intent productPageIntent = getIntent();
        Product selectedProduct = (Product)productPageIntent.getSerializableExtra("ProductInfo");

        TextView prodTxtViewTitle = findViewById(R.id.prodTxtViewTitle);
        ImageView imgViewSelectedProd = findViewById(R.id.imgViewSelectedProd);
        TextView prodTxtViewDesc = findViewById(R.id.prodTxtViewDesc);

        prodTxtViewTitle.setText(selectedProduct.getProdName());
        imgViewSelectedProd.setImageResource(selectedProduct.getProdImg());
        prodTxtViewDesc.setText(selectedProduct.getProdDesc());
    }
}