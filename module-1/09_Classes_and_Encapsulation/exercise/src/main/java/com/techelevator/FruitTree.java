package com.techelevator;

public class FruitTree {

    private String typeOfFruit;
    private int piecesOfFruitLeft;

    public FruitTree(String typeOfFruit, int startingPiecesOfFruit) {
        this.typeOfFruit = typeOfFruit;
        this.piecesOfFruitLeft = startingPiecesOfFruit;
    }

    public int numberOfPiecesToRemove = 1;

    public boolean pickFruit(int numberOfPiecesToRemove ) {
        if (this.piecesOfFruitLeft >= numberOfPiecesToRemove){
            this.piecesOfFruitLeft -= numberOfPiecesToRemove;
            return true;
        } else return false;
    }


    public String getTypeOfFruit() {
        return typeOfFruit;
    }

    public int getPiecesOfFruitLeft() {
        return piecesOfFruitLeft;
    }
}
