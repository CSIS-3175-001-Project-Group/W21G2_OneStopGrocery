package com.example.onestopgrocery.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.onestopgrocery.R;
import com.example.onestopgrocery.adapters.CartAdapter;
import com.example.onestopgrocery.databinding.FragmentCartBinding;
import com.example.onestopgrocery.entities.Cart;
import com.example.onestopgrocery.viewmodels.OneStopViewModel;

import java.text.DecimalFormat;
import java.util.List;

public class CartFragment extends Fragment implements CartAdapter.CartInterface {

    private static final String TAG = "CartFragment";
    OneStopViewModel oneStopViewModel;
    FragmentCartBinding fragmentCartBinding;
    NavController navController;

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

        navController = Navigation.findNavController(view);
        final CartAdapter cartAdapter = new CartAdapter(this);
        fragmentCartBinding.cartRecyclerView.setAdapter(cartAdapter);
        fragmentCartBinding.cartRecyclerView.addItemDecoration(new DividerItemDecoration(requireContext(),
                DividerItemDecoration.VERTICAL));

        oneStopViewModel = new ViewModelProvider(requireActivity()).get(OneStopViewModel.class);
        oneStopViewModel.getCart().observe(getViewLifecycleOwner(), new Observer<List<Cart>>() {
            @Override
            public void onChanged(List<Cart> carts) {
                cartAdapter.submitList(carts);
                fragmentCartBinding.checkoutButton.setEnabled(carts.size() > 0);
            }
        });

        oneStopViewModel.getTotalPrice().observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
                DecimalFormat df = new DecimalFormat("$##.##");
                oneStopViewModel.saveOrder(aDouble);
                fragmentCartBinding.orderTotalTextView.setText("Total: " + df.format(aDouble));
            }
        });

        fragmentCartBinding.checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_cartFragment_to_orderFragment);
            }
        });
    }

    @Override
    public void deleteProduct(Cart cart) {
        Log.d(TAG, "Deleting item " + cart.getProduct_name());
        oneStopViewModel.removeProductFromCart(cart);
    }

    @Override
    public void changeQuantity(Cart cart, int quantity) {
        oneStopViewModel.changeProductQuantity(cart, quantity);
    }
}
