package com.example.onestopgrocery.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(indices = {@Index(value = { "card_number" }, unique = true)},
        tableName = "payments")
public class Payment {
    @PrimaryKey(autoGenerate = true)
    public Long id;
    @NonNull
    @ColumnInfo(name = "payment_type_id")
    public Long paymentTypeId;
    @NonNull
    @ColumnInfo(name = "card_number")
    public String cardNumber;
    @NonNull
    @ColumnInfo(name = "card_ccv")
    public String cardCCV;
    @NonNull
    @ColumnInfo(name = "owner_name")
    public String ownerName;
    @NonNull
    @ColumnInfo(name = "card_expiry_month")
    public Integer cardExpiryMonth;
    @NonNull
    @ColumnInfo(name = "card_expiry_year")
    public Integer getCardExpiryYear;

    public Payment(String cardNumber, String cardCCV, String ownerName,
                   Integer cardExpiryMonth, Integer getCardExpiryYear) {
        this.paymentTypeId = 0l;
        this.cardNumber = cardNumber;
        this.cardCCV = cardCCV;
        this.ownerName = ownerName;
        this.cardExpiryMonth = cardExpiryMonth;
        this.getCardExpiryYear = getCardExpiryYear;
    }
}
