package com.example.onestopgrocery.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


import com.example.onestopgrocery.CheckoutActivity;
import com.example.onestopgrocery.R;
import com.example.onestopgrocery.UserProfileActivity;
import com.example.onestopgrocery.entities.Cart;
import com.example.onestopgrocery.helpers.Settings;
import com.example.onestopgrocery.viewmodels.OneStopViewModel;

import java.util.List;


public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "HomeActivity";
    private int cartQuantity = 0;
    NavController navController;
    OneStopViewModel oneStopViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        navController = Navigation.findNavController(this, R.id.navHostFragment);
        NavigationUI.setupActionBarWithNavController(this, navController);
        oneStopViewModel = new ViewModelProvider(this).get(OneStopViewModel.class);
        oneStopViewModel.getCart().observe(this, new Observer<List<Cart>>() {
            @Override
            public void onChanged(List<Cart> carts) {
                Log.d(TAG, "Cart changed " + carts.size());
                int quantity = 0;
                for (Cart cart: carts) {
                    quantity += cart.getQuantity();
                }
                cartQuantity = quantity;
                invalidateOptionsMenu();
            }
        });

        if (getIntent().hasExtra(Settings.USER_LOGGED_KEY)) {
            try {
                boolean userLoggedIn = getIntent().getBooleanExtra(Settings.USER_LOGGED_KEY, true);
                Settings.getSettings(this).edit().putBoolean(Settings.USER_LOGGED_KEY, userLoggedIn).commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (getIntent().hasExtra(Settings.USER_INFO)) {
            try {
              String rawInfo = getIntent().getStringExtra(Settings.USER_INFO);
              Settings.getSettings(this).edit().putString(Settings.USER_INFO, rawInfo).commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        navController.navigateUp();
        return super.onSupportNavigateUp();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.cartFragment);
        View actionView = menuItem.getActionView();
        TextView cartShapeTextView = actionView.findViewById(R.id.cart_shape_text_view);

        cartShapeTextView.setText(String.valueOf(cartQuantity));
        cartShapeTextView.setVisibility(cartQuantity == 0 ? View.GONE : View.VISIBLE);

        actionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOptionsItemSelected(menuItem);
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                Intent goSettings = new Intent(this, UserProfileActivity.class);
                startActivity(goSettings);
                return true;
        }
        return NavigationUI.onNavDestinationSelected(item, navController) ||
        super.onOptionsItemSelected(item);
    }

    public void buttonClick(View view) {
        switch(view.getId()) {
            case R.id.reviewOrderButton:
                EditText addLineOne = findViewById(R.id.editTextAddLineOne);
                EditText addLineTwo = findViewById(R.id.editTextAddLineTwo);
                EditText city = findViewById(R.id.editTextCity);
                Spinner province = findViewById(R.id.spinnerProvince);
                EditText postalCode = findViewById(R.id.editTextPostalCode);
                try {
                    String shippingAddress = addLineOne.getText().toString() + " "
                            + addLineTwo.getText().toString() + " "
                            + city.getText().toString() + " "
                            + province.getSelectedItem().toString() + " "
                            + postalCode.getText().toString();
                    oneStopViewModel.updateShippingAdd(Long.valueOf(1), shippingAddress);

                    Log.d(TAG, "Updated order address successfully");

                } catch (Exception e) {
                    Log.d(TAG, "Error occurred updating order " + e.getMessage());
                }
                Intent myIntent = new Intent();
                myIntent.setClassName("com.example.onestopgrocery",
                        "com.example.onestopgrocery.CheckoutActivity");
                startActivity(myIntent);
                break;
        }
    }
}
