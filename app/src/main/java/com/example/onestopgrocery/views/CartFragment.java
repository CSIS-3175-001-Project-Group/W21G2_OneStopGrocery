package com.example.onestopgrocery.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.onestopgrocery.R;
import com.example.onestopgrocery.adapters.CartAdapter;
import com.example.onestopgrocery.databinding.FragmentCartBinding;
import com.example.onestopgrocery.entities.Cart;
import com.example.onestopgrocery.viewmodels.OneStopViewModel;

import java.util.List;


public class CartFragment extends Fragment {

    private static final String TAG = "CartFragment";
    OneStopViewModel oneStopViewModel;
    FragmentCartBinding fragmentCartBinding;

    public CartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentCartBinding = FragmentCartBinding.inflate(inflater, container, false);
        return fragmentCartBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CartAdapter cartAdapter = new CartAdapter();
        fragmentCartBinding.cartRecyclerView.setAdapter(cartAdapter);
        fragmentCartBinding.cartRecyclerView.addItemDecoration(new DividerItemDecoration(requireContext(),
                DividerItemDecoration.VERTICAL));

        oneStopViewModel = new ViewModelProvider(requireActivity()).get(OneStopViewModel.class);
        oneStopViewModel.getCart().observe(getViewLifecycleOwner(), new Observer<List<Cart>>() {
            @Override
            public void onChanged(List<Cart> carts) {
                cartAdapter.submitList(carts);
            }
        });
    }
}
