package com.techelevator.dao;

import com.techelevator.model.Venue;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcVenueDao implements VenueDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcVenueDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Venue> list() {
        List<Venue> venues = new ArrayList<Venue>();
        String sql = "SELECT venue.id, venue.name, city.name AS city_name, state.name AS state_name,venue.description FROM venue " +
                "JOIN city ON venue.city_id = city.id " +
                "JOIN state ON city.state_abbreviation = state.abbreviation " +
                "ORDER BY venue.id";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while ( results.next() ) {
            Venue venue = mapRowToVenue( results );
            venue.setCategories( getCategoryForVenue( venue.getId() ) );
            venues.add( venue );
        }
        return venues;
    }

    private List<String> getCategoryForVenue(int venueId) {
        List<String> categories = new ArrayList<String>();
        String sql = "SELECT name " +
                "FROM category_venue " +
                "JOIN category ON category.id = category_venue.category_id " +
                "WHERE venue_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, venueId);
        while (result.next()) {
            categories.add( result.getString("name") );
        }
        return categories;
    }


    private Venue mapRowToVenue(SqlRowSet row) {
        Venue venue = new Venue();

        venue.setId( row.getInt("id") );
        venue.setName( row.getString("name") );
        venue.setCityName( row.getString("city_name") );
        venue.setStateName( row.getString("state_name") );
        venue.setDescription( row.getString("description") );

        return venue;
    }



}
