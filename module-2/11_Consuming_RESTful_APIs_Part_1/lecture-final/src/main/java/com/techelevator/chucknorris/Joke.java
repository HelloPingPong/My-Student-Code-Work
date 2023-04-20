package com.techelevator.chucknorris;

public class Joke {

    private String value;
    private String url;
    private String[] categories;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return value + "\nurl: " + url + "\n";
    }
}
