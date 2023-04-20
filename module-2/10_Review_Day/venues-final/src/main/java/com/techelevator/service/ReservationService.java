package com.techelevator.service;

import com.techelevator.dao.JdbcVenueDao;
import com.techelevator.dao.VenueDao;
import com.techelevator.model.Venue;

import javax.sql.DataSource;
import java.util.List;

public class ReservationService {

    private VenueDao venueDao;

    public ReservationService(DataSource dataSource) {
        venueDao = new JdbcVenueDao(dataSource);
    }

    public List<Venue> getAllVenues() {
        return venueDao.list();
    }

}
