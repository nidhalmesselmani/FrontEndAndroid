package com.example.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("first_name")
    @Expose
    private String first_name;

    @SerializedName("last_name")
    @Expose
    private String last_name;

    @SerializedName("mail")
    @Expose
    private String mail;

    @SerializedName("phone")
    @Expose
    private String phone;


    @SerializedName("date_of_birth")
    @Expose
    private String date_of_birth;

    @SerializedName("status")
    @Expose
    private String status;


    @SerializedName("place_of_birth")
    @Expose
    private String place_of_birth;

    @SerializedName("cin")
    @Expose
    private String cin;



    public User() {
    }

    public User(int id, String username,String first_name) {
        this.id = id;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String get_username() {
        return username;
    }

    public void set_username(String username) {
        this.username = username;
    }

    public String get_first_name() {
        return first_name;
    }

    public void set_first_name(String first_name) {
        this.first_name = first_name;
    }

    public String get_last_name() {
        return last_name;
    }

    public void set_last_name(String last_name) {
        this.last_name = last_name;
    }

    public String get_mail() {
        return mail;
    }

    public void set_mail(String mail) {
        this.mail = mail;
    }

    public String get_phone() {
        return mail;
    }

    public void set_phone(String mail) {
        this.mail = mail;
    }

    public String get_date_of_birth() {
        return date_of_birth;
    }

    public void set_date_of_birth(String date_of_birth) {
        this.mail = date_of_birth;
    }

    public String get_status() {
        return status;
    }

    public void set_status(String status) {
        this.mail = date_of_birth;
    }



}