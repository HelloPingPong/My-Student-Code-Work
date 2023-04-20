package com.techelevator.dao;

import com.techelevator.model.Park;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

public class JdbcParkDaoTests extends BaseDaoTests {

    private static final Park PARK_1 =
            new Park(1, "Park 1", LocalDate.parse("1800-01-02"), 100, true);
    private static final Park PARK_2 =
            new Park(2, "Park 2", LocalDate.parse("1900-12-31"), 200, false);
    private static final Park PARK_3 =
            new Park(3, "Park 3", LocalDate.parse("2000-06-15"), 300, false);

    private JdbcParkDao sut;

    private Park testPark;

    @Before
    public void setup() {
        sut = new JdbcParkDao(dataSource);
        testPark = new Park(0,"Test Park", LocalDate.parse("2022-11-17"), 777, true);
    }

    @Test
    public void getPark_returns_correct_park_for_id() {
        // Arrange
        // Act
        Park retrievedPark = sut.getPark(1);
        // Assert
        Assert.assertEquals(PARK_1, retrievedPark);

        Assert.assertEquals(PARK_3, sut.getPark(3));
    }

    @Test
    public void getPark_returns_null_when_id_not_found() {
        Park retrievedPark = sut.getPark(99);
        Assert.assertNull(retrievedPark);
    }

    @Test
    public void getParksByState_returns_all_parks_for_state() {
        List<Park> returnedParks = sut.getParksByState("AA");
        Assert.assertEquals("Wrong number of parks returned", 2, returnedParks.size());
        Assert.assertTrue("List does not contain Park 1", returnedParks.contains(PARK_1) );
        Assert.assertTrue("List does not contain Park 2", returnedParks.contains(PARK_3) );

        returnedParks = sut.getParksByState("BB");
        Assert.assertEquals("More than 1 park returned", 1, returnedParks.size());
        Assert.assertTrue("Wrong park returned", returnedParks.contains(PARK_2) );
    }

    @Test
    public void getParksByState_returns_empty_list_for_abbreviation_not_in_db() {
        Assert.assertEquals(0, sut.getParksByState("DD").size() );
    }

    /*
        This method is going to test that 1) a park can be inserted and 2) that when
        the create method is called the object it returns is correct
     */
    @Test
    public void createPark_returns_park_with_id_and_expected_values() {
        Park createdPark = sut.createPark(testPark);

        // What we are testing in this method is that createdPark is correct
        // First, lets make sure it now has an Id
        Assert.assertTrue("Park ID not assigned", createdPark.getParkId() > 0 );

        // Second, make sure the returned park matches our test.  To do so, we must set the new id onto the testPark
        testPark.setParkId( createdPark.getParkId() );
        Assert.assertEquals("Created Park has wrong data", testPark, createdPark);

    }

    /*
        This method also tests that a park can be inserted, but specifically tests that
        the right information was inserted onto to the database table
     */
    @Test
    public void created_park_has_expected_values_when_retrieved() {
        Park createdPark = sut.createPark(testPark);
        // Set the createdPark new id onto the testPark
        testPark.setParkId( createdPark.getParkId() );
        // Retrieve the park from the database using the id
        Park retrievedPark = sut.getPark( createdPark.getParkId() );

        Assert.assertEquals(testPark, retrievedPark);
    }

    @Test
    public void updated_park_has_expected_values_when_retrieved() {
        Park parkToUpdate = sut.getPark(1);

        parkToUpdate.setParkName("Updated");
        parkToUpdate.setDateEstablished(LocalDate.parse("1999-12-22"));
        parkToUpdate.setArea(999);
        parkToUpdate.setHasCamping(false);

        sut.updatePark(parkToUpdate);

        Park retrievedParkAfterUpdate = sut.getPark(1);

        Assert.assertEquals(parkToUpdate, retrievedParkAfterUpdate);
    }

    @Test
    public void deleted_park_cant_be_retrieved() {
        sut.deletePark(1);
        Park retrievedPark = sut.getPark(1);
        Assert.assertNull(retrievedPark);

        List<Park> parks = sut.getParksByState("AA");
        Assert.assertEquals(1, parks.size());
        Assert.assertTrue(parks.contains(PARK_3));
    }

    @Test
    public void park_added_to_state_is_in_list_of_parks_by_state() {
        sut.addParkToState(1, "BB");

        List<Park> parks = sut.getParksByState("BB");
        Assert.assertEquals(2, parks.size());
        Assert.assertTrue( parks.contains(PARK_1) );
    }

    @Test
    public void park_removed_from_state_is_not_in_list_of_parks_by_state() {
        sut.removeParkFromState(1, "AA");
        List<Park> parks = sut.getParksByState("AA");
        Assert.assertEquals(1, parks.size());
        Assert.assertTrue(parks.contains(PARK_3));
    }

    private void assertParksMatch(Park expected, Park actual) {
        Assert.assertEquals(expected.getParkId(), actual.getParkId());
        Assert.assertEquals(expected.getParkName(), actual.getParkName());
        Assert.assertEquals(expected.getDateEstablished(), actual.getDateEstablished());
        Assert.assertEquals(expected.getArea(), actual.getArea(), 0.1);
        Assert.assertEquals(expected.getHasCamping(), actual.getHasCamping());
    }

}
