package com.example.onestopgrocery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.onestopgrocery.helpers.Settings;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean isUserLogged = Settings.IsUserLoggedIn(getApplicationContext());
        if (isUserLogged) {
            Intent goHome = new Intent(MainActivity.this, HomeActivity.class);
            goHome.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(goHome);
        } else {
            Intent goSign = new Intent(MainActivity.this, SignUpActivity.class);
            goSign.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(goSign);
        }
    }
}
