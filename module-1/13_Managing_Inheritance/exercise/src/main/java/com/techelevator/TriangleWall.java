package com.techelevator;

public class TriangleWall extends Wall{

    public String name;
    public String color;
    private int base;
    private int height;

    public TriangleWall(String name, String color, int base, int height) {
        this.name = name;
        this.color = color;
        this.base = base;
        this.height = height;

    }




    @Override
    public int getArea(){
        int area = (base*height)/2;
        return area;

    }


    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
