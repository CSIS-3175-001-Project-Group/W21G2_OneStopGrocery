package com.example.onestopgrocery;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;

import java.math.BigDecimal;

public class CheckoutActivity extends AppCompatActivity {

    private Button confirmPayBtn;
    private int PAYPAL_REQ_CODE = 12;
    private static PayPalConfiguration paypalConfig = new PayPalConfiguration()
            .environment(PayPalConfiguration.ENVIRONMENT_SANDBOX)
            .clientId(PaypalConfig.PAYPAL_CLIENT_ID);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        confirmPayBtn = findViewById(R.id.confirmPayBtn);

        Intent intent = new Intent(this, PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, paypalConfig);
        startService(intent);


        confirmPayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                payWithPayPal();
            }
        });
    }

    private void payWithPayPal() {

        PayPalPayment payment = new PayPalPayment(new BigDecimal(100), "CAD",
                "Complete Your Payment", PayPalPayment.PAYMENT_INTENT_SALE);

        Intent payIntent = new Intent(this, PaymentActivity.class);
        payIntent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, paypalConfig);
        payIntent.putExtra(PaymentActivity.EXTRA_PAYMENT, payment);

        startActivityForResult(payIntent, PAYPAL_REQ_CODE);

    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PAYPAL_REQ_CODE) {
            System.out.println("Request code reached");
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(this, "Payment completed successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Payment was unsuccessful", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onDestroy() {
        stopService(new Intent(this, PayPalService.class));
        super.onDestroy();
    }
}