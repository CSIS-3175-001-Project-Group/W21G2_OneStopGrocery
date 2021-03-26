package com.example.onestopgrocery.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onestopgrocery.databinding.ProductRowBinding;
import com.example.onestopgrocery.entities.Product;

public class GroceryProductAdapter extends ListAdapter<Product, GroceryProductAdapter.GroceryViewHolder> {

    GroceryProductInterface groceryProductInterface;

    public GroceryProductAdapter(GroceryProductInterface groceryProductInterface) {
        super(Product.itemCallback);
        this.groceryProductInterface = groceryProductInterface;
    }

    @NonNull
    @Override
    public GroceryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ProductRowBinding productRowBinding = ProductRowBinding.inflate(layoutInflater, parent,
                false);
        productRowBinding.setGroceryProductInterface(groceryProductInterface);
        return new GroceryViewHolder(productRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull GroceryViewHolder holder, int position) {
        Product product = getItem(position);
        holder.productRowBinding.setProduct(product);
        holder.productRowBinding.executePendingBindings();
    }

    class GroceryViewHolder extends RecyclerView.ViewHolder {

        ProductRowBinding productRowBinding;

        public GroceryViewHolder(ProductRowBinding binding) {
            super(binding.getRoot());
            this.productRowBinding = binding;
        }
    }

    public interface GroceryProductInterface {
        void addItem(Product product);
        void onItemClick(Product product);
    }
}
