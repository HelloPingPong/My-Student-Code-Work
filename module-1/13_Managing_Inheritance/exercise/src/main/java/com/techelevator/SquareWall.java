package com.techelevator;

public class SquareWall extends RectangleWall {

    public String name;
    public String color;
    private int sideLength;

    public SquareWall(String name, String color, int sideLength) {

        this.name = name;
        this.color = color;
        this.sideLength = sideLength;
    }

    public SquareWall(String name, String color, int length, int height) {
        super(name, color, length, height);
        this.name = name;
        this.color = color;
    }


    @Override
    public String toString() {
        return name + " (" + sideLength + "x" + sideLength + ") square";
    }

    @Override
    public int getArea() {
        int area = sideLength*sideLength;
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

    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        this.sideLength = sideLength;
    }
}

