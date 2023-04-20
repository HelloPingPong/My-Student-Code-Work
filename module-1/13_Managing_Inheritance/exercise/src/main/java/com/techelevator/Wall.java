package com.techelevator;
import java.util.Map;



public abstract class Wall {

    private String name;
    private String color;

    public Wall(final String name, final String color){
        this.name = name;
        this.color = color;
    }

    public Wall() {
    }


    public abstract int getArea();{

    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
}
