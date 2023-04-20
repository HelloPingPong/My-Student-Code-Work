package com.techelevator;

import com.techelevator.dao.JdbcVenueDao;
import com.techelevator.dao.VenueDao;
import com.techelevator.model.Venue;
import org.junit.*;

import java.util.Arrays;
import java.util.List;

public class JdbcVenueDaoTests extends BaseDaoTests {

    private final static String[] VENUE_1_CATEGORIES = {"Family Friendly","Modern"};
    private final static Venue VENUE_1 = new Venue(1,"Hidden Owl Eatery", "Bona", "Michigan",
            "This venue has plenty of \"property\" to enjoy. Roll the dice and check out all of our spaces.");

    private VenueDao venueDao;

    @Before
    public void setup() {
        VENUE_1.setCategories( Arrays.asList(VENUE_1_CATEGORIES) );
        venueDao = new JdbcVenueDao(dataSource);
    }

    @Test
    public void list_returns_all_venues() {
        List<Venue> venues = venueDao.list();
        Assert.assertEquals("Wrong number of venues returned", 15, venues.size());
        Assert.assertTrue( venues.contains(VENUE_1) );
    }
}
