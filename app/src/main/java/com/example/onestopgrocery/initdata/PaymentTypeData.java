package com.example.onestopgrocery.initdata;

import com.example.onestopgrocery.entities.PaymentType;

import java.util.ArrayList;
import java.util.List;

public class PaymentTypeData {
    private List<PaymentType> paymentTypeList;
    public PaymentTypeData() {
        paymentTypeList = new ArrayList<>();

        paymentTypeList.add(new PaymentType("Debit", "Regular debit card", 0));
        paymentTypeList.add(new PaymentType("Credit", "Regular credit card", 1));
    }

    public List<PaymentType> getData() {
        return this.paymentTypeList;
    }
}
