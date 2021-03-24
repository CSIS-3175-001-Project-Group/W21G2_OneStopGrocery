package com.example.onestopgrocery;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.onestopgrocery.dao.UserDao;
import com.example.onestopgrocery.entities.User;

public class RegisterActivity extends AppCompatActivity {

    EditText name;
    EditText email;
    EditText password;
    TextView login;
    Button register;

    AlertDialog errorDialog;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        handler = new Handler();

        EditText txtName = findViewById(R.id.txtCustName2);
        EditText txtEmail = findViewById(R.id.txtEmail);
        EditText txtPass = findViewById(R.id.txtPass);
        TextView loginBtn = findViewById(R.id.btnSignIn);
        Button btnRegNew = findViewById(R.id.btnCreateNew);

        errorDialog = new AlertDialog.Builder(this).create();
        errorDialog.setTitle("Error");

        loginBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btnRegNew.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                UserDao userDao = OneStopDatabase.getInstance(v.getContext()).userDao();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        User user = userDao.findByEmail(txtEmail.getText().toString());
                        if (user != null) {
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    errorDialog.setMessage("Such user email already exists. Please try using different email.");
                                    errorDialog.show();
                                }
                            });
                        } else {
                            User newUser = new User() {
                                {
                                    fullName = txtName.getText().toString();
                                    login = txtEmail.getText().toString();
                                    email = txtEmail.getText().toString();
                                    password = txtPass.getText().toString();
                                }
                            };

                            userDao.insert(newUser);

                            Intent goHome = new Intent(v.getContext(), HomeActivity.class);
                            goHome.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(goHome);
                        }
                    }
                }).start();
            }
        });
    }
}