package com.example.onestopgrocery.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.onestopgrocery.R;
import com.example.onestopgrocery.databinding.FragmentProductBinding;
import com.example.onestopgrocery.databinding.FragmentProductDetailBinding;
import com.example.onestopgrocery.databinding.FragmentProductDetailBindingImpl;
import com.example.onestopgrocery.viewmodels.OneStopViewModel;


public class ProductDetailFragment extends Fragment {

    FragmentProductDetailBinding fragmentProductDetailBinding;
    OneStopViewModel oneStopViewModel;

    public ProductDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentProductDetailBinding = FragmentProductDetailBinding.inflate(inflater, container, false);
        return fragmentProductDetailBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        oneStopViewModel = new ViewModelProvider(requireActivity()).get(OneStopViewModel.class);
        fragmentProductDetailBinding.setOneStopViewModel(oneStopViewModel);
    }
}
