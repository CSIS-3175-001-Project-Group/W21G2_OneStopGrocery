package com.example.onestopgrocery.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.onestopgrocery.R;

public class OrderConfirmationActivity extends AppCompatActivity {
    Button continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmation);

        continueButton = findViewById(R.id.continueButton);
        continueButton.setOnClickListener((View v) -> {
                Intent backToHome = new Intent(this, HomeActivity.class);
                startActivity(backToHome);
            });
    }
}
