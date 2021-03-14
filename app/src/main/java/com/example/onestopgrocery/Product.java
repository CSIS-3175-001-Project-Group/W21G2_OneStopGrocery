package com.example.onestopgrocery;

import java.io.Serializable;

public class Product implements Serializable {
    int prodId;
    String prodName;
    String prodDesc;
    int prodImg;

    public Product(int prodId, String prodName, String prodDesc, int prodImg) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.prodDesc = prodDesc;
        this.prodImg = prodImg;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdDesc() {
        return prodDesc;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }

    public int getProdImg() {
        return prodImg;
    }

    public void setProdImg(int prodImg) {
        this.prodImg = prodImg;
    }
}
