package com.techelevator;

import com.techelevator.dao.JdbcVenueDao;
import com.techelevator.dao.VenueDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JdbcVenueDaoTests  extends BaseDaoTests{

    private VenueDao venueDao;
//this is everything to a test class before we have written the test.
    @Before
    public void setup(){
        venueDao = new JdbcVenueDao(dataSource);
    }

    @Test
    public void list_resturns_all_venues() {
        List<Venue> venues = venueDao.list();

        Assert.assertEquals("Wrong number of venues returned", 15, venues.size());
    }



}
