package com.example.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Place {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("coordinates")
    @Expose
    private String coordinates;

    @SerializedName("contaminated")
    @Expose
    private Character contaminated;

    @SerializedName("city_id")
    @Expose
    private Integer cityId;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("number_of_visits")
    @Expose
    private Integer numberOfVisits;

    @SerializedName("number_of_reports")
    @Expose
    private Integer numberOfReports;

    public Place() {
    }

    public Place(int id, String coordinates, Character contaminated, Integer cityId, String name, Integer numberOfVisits, Integer numberOfReports) {
        this.id = id;
        this.coordinates = coordinates;
        this.contaminated = contaminated;
        this.cityId = cityId;
        this.name = name;
        this.numberOfVisits = numberOfVisits;
        this.numberOfReports = numberOfReports;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public Character getContaminated() {
        return contaminated;
    }

    public void setContaminated(Character contaminated) {
        this.contaminated = contaminated;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfVisits() {
        return numberOfVisits;
    }

    public void setNumberOfVisits(Integer numberOfVisits) {
        this.numberOfVisits = numberOfVisits;
    }

    public Integer getNumberOfReports() {
        return numberOfReports;
    }

    public void setNumberOfReports(Integer numberOfReports) {
        this.numberOfReports = numberOfReports;
    }
}