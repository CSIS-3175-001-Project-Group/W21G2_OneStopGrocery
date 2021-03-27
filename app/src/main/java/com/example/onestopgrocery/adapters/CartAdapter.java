package com.example.onestopgrocery.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onestopgrocery.databinding.CartRowBinding;
import com.example.onestopgrocery.entities.Cart;


public class CartAdapter extends ListAdapter<Cart, CartAdapter.CartViewHolder> {

    private CartInterface cartInterface;
    public CartAdapter(CartInterface cartInterface) {
        super(Cart.itemCallback);
        this.cartInterface = cartInterface;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        CartRowBinding cartRowBinding = CartRowBinding.inflate(
                layoutInflater, parent, false);
        return new CartViewHolder(cartRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        holder.cartRowBinding.setCart(getItem(position));
        holder.cartRowBinding.executePendingBindings();
    }

    class CartViewHolder extends RecyclerView.ViewHolder {

        CartRowBinding cartRowBinding;

        public CartViewHolder(@NonNull CartRowBinding cartRowBinding) {
            super(cartRowBinding.getRoot());
            this.cartRowBinding = cartRowBinding;

            cartRowBinding.deleteProductButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cartInterface.deleteProduct(getItem(getAdapterPosition()));
                }
            });
        }
    }

    public interface CartInterface {
        void deleteProduct(Cart cart);
    }
}
