package com.example.onestopgrocery.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(primaryKeys = {"id", "email", "login"}, tableName = "users")
public class User {
    public int id;

    @ColumnInfo(name = "full_name")
    public String fullName;
    @NonNull
    public String email;
    @NonNull
    public String login;
    public String password;
    public Double budget;
    @ColumnInfo(name = "logo_resource")
    public Integer logoResource;
    public String country;
    public String city;
}
