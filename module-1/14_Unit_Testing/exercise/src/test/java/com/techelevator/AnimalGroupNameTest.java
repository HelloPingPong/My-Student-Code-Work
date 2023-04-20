package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
//these exercises are scored manually. no need to get all green tests. the point is testing appropriately.
// will be evaluated based off "Did you write enough test cases and the right kind of cases?"
// you don't have to write every test possible. the point is finding and taking edge cases into account.
// an additional one or two cases per test should be fine.
// don't just write the same test over and over.
// VERIFY TEST IS CORRECT AND THAT PROVIDED CODE IS FAILING

public class AnimalGroupNameTest {

    private AnimalGroupName target;

    @Before
    public void setup() {
        target = new AnimalGroupName();
    }

    @Test
    public void correct_herd_name_returned() {
        String actualHerdName = target.getHerd("giraffe"); //what you put in
        Assert.assertEquals("Tower", actualHerdName); // what you think its going to be, what it actually was
    }

}
