package com.example.onestopgrocery.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.onestopgrocery.R;
import com.example.onestopgrocery.adapters.GroceryProductAdapter;
import com.example.onestopgrocery.databinding.FragmentProductBinding;
import com.example.onestopgrocery.entities.Product;
import com.example.onestopgrocery.viewmodels.OneStopViewModel;
import com.google.android.material.snackbar.Snackbar;


public class ProductCatalogFragment extends Fragment
        implements GroceryProductAdapter.GroceryProductInterface {

    private static final String TAG = "ProductCatalogFragment";
    FragmentProductBinding fragmentProductBinding;
    private GroceryProductAdapter groceryProductAdapter;
    private OneStopViewModel oneStopViewModel;
    private NavController navController;

    public ProductCatalogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentProductBinding = FragmentProductBinding.inflate(
                inflater, container, false);
        return fragmentProductBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        groceryProductAdapter = new GroceryProductAdapter(this);
        fragmentProductBinding.productRecyclerView.setAdapter(groceryProductAdapter);
        fragmentProductBinding.productRecyclerView.addItemDecoration(
                new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
        fragmentProductBinding.productRecyclerView.addItemDecoration(
                new DividerItemDecoration(requireContext(), DividerItemDecoration.HORIZONTAL));

        oneStopViewModel = new ViewModelProvider(requireActivity()).get(OneStopViewModel.class);
        oneStopViewModel.getProducts().observe(getViewLifecycleOwner(),
                products -> groceryProductAdapter.submitList(products));

        navController = Navigation.findNavController(view);
    }

    @Override
    public void addItem(Product product) {
        Log.d(TAG, "Adding item: " + product.getName());
        boolean productAdded = oneStopViewModel.addProductToCart(product);
        Log.d(TAG, "Item " + product.getName() + " added to cart");
        if (productAdded) {
            Snackbar.make(requireView(), product.getName() + " added to cart.", Snackbar.LENGTH_LONG)
                    .setAction("Checkout", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            navController.navigate(R.id.action_productCatalogFragment_to_cartFragment);
                        }
                    }).show();
        } else {
            Snackbar.make(requireView(),"Product limit reached.", Snackbar.LENGTH_LONG);
        }

    }

    @Override
    public void onItemClick(Product product) {
        Log.d(TAG, "Item clicked: " + product.toString());
        oneStopViewModel.setProduct(product);
        navController.navigate(R.id.action_productCatalogFragment_to_productDetailFragment);
    }
}
