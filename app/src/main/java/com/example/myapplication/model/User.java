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

    public User(int id,
                String username,
                String first_name,
                String last_name,
                String mail,
                String phone,
                String date_of_birth,
                String status,
                String place_of_birth,
                String cin
                ) {

        this.id = id;
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.mail = mail;
        this.phone = phone;
        this.date_of_birth = date_of_birth;
        this.status = status;
        this.place_of_birth = place_of_birth;
        this.cin = cin;
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

    public String get_place_of_birth() {
        return place_of_birth;
    }

    public void set_place_of_birth(String place_of_birth) {
        this.place_of_birth = place_of_birth;
    }

    public String get_cin() {
        return cin;
    }

    public void set_cin(String cin) {
        this.cin = cin;
    }

}