package com.techelevator.model;

import java.util.List;
import java.util.Objects;

public class Venue {

    private int id;
    private String name;
    private String cityName;
    private String stateName;
    private String description;
    private List<String> categories;

    public Venue() {

    }

    public Venue(int id, String name, String cityName, String stateName, String description) {
        this.id = id;
        this.name = name;
        this.cityName = cityName;
        this.stateName = stateName;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venue venue = (Venue) o;
        return id == venue.id && Objects.equals(name, venue.name) && Objects.equals(cityName, venue.cityName) && Objects.equals(stateName, venue.stateName) && Objects.equals(description, venue.description) && Objects.equals(categories, venue.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cityName, stateName, description, categories);
    }

}
