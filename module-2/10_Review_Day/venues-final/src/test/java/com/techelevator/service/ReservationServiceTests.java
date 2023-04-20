package com.techelevator.service;

import com.techelevator.BaseDaoTests;
import com.techelevator.model.Venue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ReservationServiceTests extends BaseDaoTests {

    private ReservationService reservationService;

    @Before
    public void setup() {
        reservationService = new ReservationService(dataSource);
    }

    @Test
    public void list_of_venues_is_returned() {
        List<Venue> venues = reservationService.getAllVenues();
        Assert.assertNotNull(venues);
        Assert.assertEquals(15, venues.size());
    }
}
