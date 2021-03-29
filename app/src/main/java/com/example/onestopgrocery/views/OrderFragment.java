package com.example.onestopgrocery.views;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.onestopgrocery.CheckoutActivity;
import com.example.onestopgrocery.R;
import com.example.onestopgrocery.viewmodels.OneStopViewModel;


public class OrderFragment extends Fragment {

    private static final String TAG = "OrderFragment";
    OneStopViewModel oneStopViewModel;

    public OrderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_order, container, false);
    }


}
