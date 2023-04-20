package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AnimalGroupNameTest {

    private AnimalGroupName target;

    @Before
    public void setup() {
        target = new AnimalGroupName();
    }

    @Test
    public void correct_herd_name_returned() {
        String actualHerdName = target.getHerd("giraffe");
        Assert.assertEquals("Tower", actualHerdName);
    }
}
