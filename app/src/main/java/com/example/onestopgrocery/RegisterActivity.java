package com.example.onestopgrocery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    EditText name;
    EditText email;
    EditText password;
    TextView login;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText Name = findViewById(R.id.txtCustName2);
        EditText Email = findViewById(R.id.txtEmail);
        EditText Password = findViewById(R.id.password);
        TextView Login = findViewById(R.id.txtSignIn2);
        Button Register = findViewById(R.id.btnCreateAcc2);

        Login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }

        });
    }
}