package com.techelevator.exercises;

import org.junit.*;

public class WithoutEndTest {

    /*
        -Hello -> ell
        -abc ->  b
        -ab -> ""
        "" -> ""
        -a -> ""
        null -> ""
     */

    private WithoutEnd target;

    @Before
    public void setup() {
        target = new WithoutEnd();
    }

    @Test
    public void word_returns_without_first_and_last_letter() {
        // Arrange
        // Act
        String result = target.withoutEnd("Hello");
        // Assert
        /*
            first Argument - expected result
            second argument - actual result
         */
        Assert.assertEquals("ell", result);
    }

    @Test
    public void one_letter_returns_when_input_is_3_characters() {
        /*
            Can call the target method and pass the output directly into the Assert,
            if we want
         */
        Assert.assertEquals("b", target.withoutEnd("abc"));
    }

    @Test
    public void empty_string_when_input_is_1_char() {
        String actualResult = target.withoutEnd("a");
        /*
            Can add a first argument to any assert method with a custom message to
            be shown when the test fails
         */
        Assert.assertEquals("An optional custom message can be added to any assert as the first argument",
                "", actualResult);
    }

    @Test
    public void empty_string_when_input_is_2_char() {
        String actualResult = target.withoutEnd("ab");
        Assert.assertEquals("", actualResult);
    }

    @Test
    public void empty_string_when_input_is_empty() {
        String actualResult = target.withoutEnd("");
        Assert.assertEquals("", actualResult);
    }

    @Test
    public void empty_string_when_input_is_null() {
        String actualResult = target.withoutEnd(null);
        Assert.assertEquals("", actualResult);
    }

}
