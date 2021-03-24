package com.example.onestopgrocery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.lifecycle.LiveData;

import com.example.onestopgrocery.dao.ProductDao;
import com.example.onestopgrocery.entities.Product;

import java.util.List;

public class ProductAdapter extends BaseAdapter {
    private List<Product> productList;

    public ProductAdapter(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Product getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return productList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_product, parent, false);
            convertView.setLayoutParams(new ViewGroup.LayoutParams(GridView.AUTO_FIT, 512));
        }

        TextView prodNameTxtView = convertView.findViewById(R.id.prodNameTxtView);
        ImageView prodImgView = convertView.findViewById(R.id.prodImgView);
        TextView prodDescTxtView = convertView.findViewById(R.id.prodDescTextView);

        prodNameTxtView.setText(productList.get(position).getName());
        prodImgView.setImageResource(productList.get(position).getLogoResource());
        prodDescTxtView.setText(productList.get(position).getDescription());

        return convertView;
    }
}
