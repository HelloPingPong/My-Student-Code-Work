package com.techelevator.trees;

import org.junit.*;

/*
    -1) pick fruit success when enough fruit on tree and right amount of
        fruit remains
    -2) can't pick too many fruit
    -3) Pick all the fruit on the tree
    -4) Pick 0 fruit
    -5) Pick negative fruit
    -6) Right type of fruit tree
    -7) can't pick fruit after picking all fruit
    -8) pick fruit multiple times
 */

public class FruitTreeTest {

    private FruitTree fruitTree;

    @Before
    public void createFruitTree() {
        fruitTree = new FruitTree("Pear", 20);
    }

    @Test
    public void tree_contains_correct_type_of_fruit() {
        String actualTypeOfFruit = fruitTree.getTypeOfFruit();
        Assert.assertEquals("Pear", actualTypeOfFruit);
    }

    @Test
    public void pick_fruit_successfully() {
        // Act
        boolean result = fruitTree.pickFruit(5);
        // Assert
        Assert.assertTrue("pickFruit returned false", result);
        int fruitLeftOnTree = fruitTree.getPiecesOfFruitLeft();
        Assert.assertEquals("Wrong number of fruit remaining",
                15, fruitLeftOnTree);

    }

    @Test
    public void cant_pick_too_many_fruit() {
        Assert.assertFalse("Returned false",
                fruitTree.pickFruit(21) );
        Assert.assertEquals("Wrong number of fruit remaining",
                20, fruitTree.getPiecesOfFruitLeft() );
    }

    @Test
    public void can_pick_all_the_fruit() {
        Assert.assertTrue("Returned false",
                fruitTree.pickFruit(20) );
        Assert.assertEquals("Wrong number of fruit remaining",
                0, fruitTree.getPiecesOfFruitLeft() );
    }

    @Test
    public void cant_pick_0_fruit() {
        Assert.assertTrue("Returned false",
                fruitTree.pickFruit(0) );
        Assert.assertEquals("Wrong number of fruit remaining",
                20, fruitTree.getPiecesOfFruitLeft() );
    }

    @Test
    public void cant_pick_negative_fruit() {
        Assert.assertFalse("Returned true",
                fruitTree.pickFruit(-1) );
        Assert.assertEquals("Wrong number of fruit remaining",
                20, fruitTree.getPiecesOfFruitLeft() );
    }

    @Test
    public void can_pick_fruit_multiple_times() {
        // Arrange
        fruitTree.pickFruit(5);
        // Act (Test)
        boolean result = fruitTree.pickFruit(5);
        Assert.assertTrue(result);
        Assert.assertEquals(10, fruitTree.getPiecesOfFruitLeft() );
    }

    @Test
    public void cant_pick_fruit_after_all_fruit_has_been_picked() {
        // Arrange
        fruitTree.pickFruit(20);
        // Act (Test)
        boolean result = fruitTree.pickFruit(1);
        Assert.assertFalse(result);
        Assert.assertEquals(0, fruitTree.getPiecesOfFruitLeft() );
    }
}
