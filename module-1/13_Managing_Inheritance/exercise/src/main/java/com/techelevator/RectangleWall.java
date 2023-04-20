package com.techelevator;

public class RectangleWall extends Wall {

    public String name;
    public String color;
    private int length;
    private int height;


    public RectangleWall(String name, String color, int length, int height){
        super(name, color);
        this.name = name;
        this.color = color;
        this.length = length;
        this.height = height;


    }

    public RectangleWall() {
    }

    @Override
    public String toString() {
        return name + " (" + length + "x" + height + ") rectangle";

    }

    @Override
    public int getArea() {
        int area = length*height;
        return area;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
