package com.example.onestopgrocery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends BaseAdapter {
    List<Product> productList;

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
        return productList.get(position).getProdId();
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

        prodNameTxtView.setText(productList.get(position).getProdName());
        prodImgView.setImageResource(productList.get(position).getProdImg());
        prodDescTxtView.setText(productList.get(position).getProdDesc());

        return convertView;
    }
}
