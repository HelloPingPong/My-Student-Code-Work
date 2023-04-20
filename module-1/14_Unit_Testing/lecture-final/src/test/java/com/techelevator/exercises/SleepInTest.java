package com.techelevator.exercises;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SleepInTest {

    private SleepIn target;

    /*
        A method marked with @Before will run Before EVERY test
        Optional - can be 0 or 1 method with @Before

        Commonly used to instantiate a new instance of the object we are testing
     */
    @Before
    public void setup() {
        target = new SleepIn();
    }


    /*
        A method marked with @After will run After EVERY test
        Optional - can be 0 or 1 method with @After

        Commonly not needed.  Here it is only being included as an example of @After.
     */
    @After
    public void cleanup() {
        System.out.println("This is in the @After");
    }

    @Test
    public void sleep_in_when_on_vacation_and_weekend() {
        // Arrange (Setup)
        // Act
        boolean result = target.sleepIn(false, true);
        // Assert
        Assert.assertTrue( result );
    }

    @Test
    public void sleep_in_when_on_vacation_and_weekday() {
        // Arrange (Setup)
        // Act
        boolean result = target.sleepIn(true, true);
        // Assert
        Assert.assertTrue( result );
    }

    @Test
    public void dont_sleep_in_when_not_on_vacation_and_weekday() {
        // Arrange
        // Act
        boolean result = target.sleepIn(true, false);
        // Assert
        Assert.assertFalse( result );
    }

    @Test
    public void sleep_in_when_weekend_and_not_on_vacation() {
        // Arrange
        // Act
        boolean result = target.sleepIn(false, false);
        // Assert
        Assert.assertTrue(result);
    }

}
