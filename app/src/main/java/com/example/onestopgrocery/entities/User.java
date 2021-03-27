package com.example.onestopgrocery.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.Junction;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

@Entity(indices = {@Index(value = { "email", "login" }, unique = true)},
        tableName = "users")
public class User {
    @PrimaryKey(autoGenerate = true)
    public Long id;
    @ColumnInfo(name = "full_name")
    public String fullName;
    @NonNull
    public String email;
    @NonNull
    public String login;
    public String password;
    public String phone;
    public Double budget;
    @ColumnInfo(name = "logo_resource")
    public Integer logoResource;
    public String country;
    public String city;

    public Long getId() {
        return id;
    }
}
