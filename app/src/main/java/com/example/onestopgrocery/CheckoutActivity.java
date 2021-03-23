package com.example.onestopgrocery;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.onestopgrocery.entities.Payment;
import com.paypal.android.sdk.payments.PayPalAuthorization;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalFuturePaymentActivity;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import org.json.JSONException;

import java.math.BigDecimal;

public class CheckoutActivity extends AppCompatActivity {

    private Button confirmPayBtn;
    public static final String PAYPAL_CLIENT_ID = "ATPH0F2wZMnXnvlr_Zdb3Zr249c6DTvbDjD7e2SWTEh-dsrJNuulD7hQ5cFegs6Dv1GLG1jEW04yB3ah";
    private static final int REQ_CODE_PAYMENT = 1;
    private static final int REQ_CODE_FUTURE_PAYMENT = 2;
    private static final String CONFIG_ENV = PayPalConfiguration.ENVIRONMENT_NO_NETWORK;
    private static PayPalConfiguration payPalConfig;
    PayPalPayment cartPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        confirmPayBtn = findViewById(R.id.confirmPayBtn);

        confirmPayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                payWithPayPal();
            }
        });
        configPayPal();
    }

    private void configPayPal() {
        payPalConfig = new PayPalConfiguration()
        .environment(CONFIG_ENV)
        .clientId(PAYPAL_CLIENT_ID)
        .merchantName("PayPal Login")
        .merchantPrivacyPolicyUri(Uri.parse("https://www.example.com/privacy"))
        .merchantUserAgreementUri(Uri.parse("https:www/example.com/legal"));

    }

    private void payWithPayPal() {

        Intent intent = new Intent(this, PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, payPalConfig);
        startService(intent);

        cartPayment = new PayPalPayment(new BigDecimal(String.valueOf("9.99")), "CAD",
                "Complete Payment", PayPalPayment.PAYMENT_INTENT_SALE);
        Intent paymentIntent = new Intent(this, PaymentActivity.class);
        paymentIntent.putExtra(PaymentActivity.EXTRA_PAYMENT, cartPayment);
        paymentIntent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, payPalConfig);
        startActivityForResult(paymentIntent, REQ_CODE_PAYMENT);

    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQ_CODE_PAYMENT) {
            if (resultCode == Activity.RESULT_OK) {
                PaymentConfirmation confirm = data
                        .getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
                if (confirm != null) {
                    try {
                        System.out.println(confirm.toJSONObject()
                                .toString(4));
                    } catch (JSONException e) {
                        Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "Payment has been cancelled", Toast.LENGTH_SHORT).show();
            } else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID) {
                Toast.makeText(this, "An error occurred while processing payment", Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == REQ_CODE_FUTURE_PAYMENT) {
            if (resultCode == Activity.RESULT_OK) {
                PayPalAuthorization authorization = data.getParcelableExtra(PayPalFuturePaymentActivity.EXTRA_RESULT_AUTHORIZATION);
                if (authorization != null) {
                    try {
                        Log.i("Future Payment", authorization.toJSONObject().toString(4));
                        String authorization_code = authorization.getAuthorizationCode();
                        Log.d("Future Payment", authorization_code);
                    } catch (Exception e) {
                        Log.d("Future Payment", e.toString());
                    }
                }
            }
        }
    }

    @Override
    protected void onDestroy() {
        stopService(new Intent(this, PayPalService.class));
        super.onDestroy();
    }
}
