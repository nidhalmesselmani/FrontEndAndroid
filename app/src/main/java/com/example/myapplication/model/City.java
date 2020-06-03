package com.example.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class City {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("governorate_id")
    @Expose
    private int governorate_id;

    @SerializedName("name")
    @Expose
    private String name;

    public City() {
    }

    public City(int id, String name, int governorate_id) {
        this.id = id;
        this.governorate_id = governorate_id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGovernorateId() {
        return governorate_id;
    }

    public void setGovernorateId(int governorate_id) {
        this.governorate_id = governorate_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
