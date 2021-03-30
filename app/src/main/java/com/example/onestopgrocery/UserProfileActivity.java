package com.example.onestopgrocery;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.onestopgrocery.entities.User;
import com.example.onestopgrocery.helpers.Settings;
import com.example.onestopgrocery.views.HomeActivity;

import static com.example.onestopgrocery.helpers.Settings.getLoggedUserData;

public class UserProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        ImageView imageView = findViewById(R.id.imgUserPhoto);
        TextView name =  findViewById(R.id.txtInfoUserName);
        TextView email = findViewById(R.id.txtInfoUserEmail);
        TextView id = findViewById(R.id.txtInfoUserLogin);
        Button signOut = findViewById(R.id.btnSignOut);
        Button homeback = findViewById(R.id.btnBackHome);

        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    // ...
                    case R.id.btnSignOut:
                        Settings.signOut(view.getContext(), new Settings.OnSignOff() {
                            @Override
                            public void onSignOffComplete() {
                                Intent goSign = new Intent(UserProfileActivity.this, SignUpActivity.class);
                                goSign.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                goSign.putExtra("toast_msg", "Sign out Successfully");
                                startActivity(goSign);
                            }
                        });
                        break;
                    // ...
                }

            }
        });

        homeback.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfileActivity.this, HomeActivity.class);
                startActivity(intent);
            }

        });

        User user = getLoggedUserData(this);

        if (user != null) {
            name.setText(user.fullName);
            email.setText(user.email);
            id.setText(user.login);
        } else {
            AlertDialog errorDialog = new AlertDialog.Builder(this).create();
            errorDialog.setTitle("Error");
            errorDialog.setMessage("Can't find user data!");
            errorDialog.show();
        }
    }
}