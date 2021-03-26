package com.example.onestopgrocery;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.onestopgrocery.entities.User;
import com.example.onestopgrocery.helpers.Settings;
import com.example.onestopgrocery.views.HomeActivity;

public class LoginActivity extends AppCompatActivity {

    private AppDatabase db;
    private Handler handler;
    private AlertDialog infoDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        handler = new Handler();

        db = AppDatabase.getDatabase(getApplication());

        infoDialog = new AlertDialog.Builder(this).create();

        TextView txtLogin = findViewById(R.id.txtLoginEmail);
        TextView txtPass = findViewById(R.id.txtLoginPass);

        TextView btnForgotPass = findViewById(R.id.btnForgotPass);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, PasswordActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("TEST", "OnLoginClick");
                        User user = db.userDao().findByEmail(txtLogin.getText().toString());
                        if (user != null) {
                            if (txtPass.getText().toString().equals(user.password)) {
                                Intent goHome = new Intent(v.getContext(), HomeActivity.class);
                                goHome.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                goHome.putExtra(Settings.USER_LOGGED_KEY, true);
                                goHome.putExtra(Settings.USER_INFO, String.format("%s|%s|%s", user.login, user.fullName, user.email));
                                startActivity(goHome);
                            } else {
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        infoDialog.setTitle("Warning");
                                        infoDialog.setMessage("User or email is incorrect!");
                                        infoDialog.show();
                                    }
                                });
                            }
                        } else {
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    infoDialog.setTitle("Warning");
                                    infoDialog.setMessage("User with such email doesn't exist!");
                                    infoDialog.show();
                                }
                            });
                        }
                    }
                }).start();
            }
        });

    }
}