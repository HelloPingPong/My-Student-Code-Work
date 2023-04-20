package com.techelevator.dao;

import com.techelevator.model.Park;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcParkDao implements ParkDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcParkDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Park getPark(int parkId) {
        Park park = null;
        String sql = "SELECT park_id, park_name, date_established, area, has_camping " +
                "FROM park WHERE park_id = ?";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, parkId);
        while (rows.next()) {
            park = mapRowToPark( rows );
        }
        return park;
    }

    @Override
    public List<Park> getParksByState(String stateAbbreviation) {

        List<Park> parks = new ArrayList<Park>();
        String sql = "SELECT park.park_id, park_name, date_established, area, has_camping " +
                "FROM park " +
                "JOIN park_state ON park.park_id = park_state.park_id " +
                "WHERE park_state.state_abbreviation = ?";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, stateAbbreviation);

        while (rows.next()) {
            parks.add( mapRowToPark(rows) );
        }

        return parks;
    }

    /*
        This insert uses QueryForRowSet because it has a RETURNING clause
     */
    @Override
    public Park createPark(Park park) {
        String sql = "INSERT INTO park (park_name, date_established, area, has_camping) " +
                "VALUES (?, ?, ?, ?) RETURNING park_id";
        Integer newParkId = jdbcTemplate.queryForObject(sql, Integer.class, park.getParkName(),
                park.getDateEstablished(), park.getArea(), park.getHasCamping() );
        park.setParkId( newParkId );
        return park;
    }

    @Override
    public void updatePark(Park park) {
        String sql = "UPDATE park " +
                "SET park_name = ?, date_established = ?, area = ?, has_camping = ? " +
                "WHERE park_id = ?";
        jdbcTemplate.update(sql, park.getParkName(), park.getDateEstablished(),
                park.getArea(), park.getHasCamping(), park.getParkId());
    }

    @Override
    public void deletePark(int parkId) {
        removeParkFromAllStates(parkId);
        jdbcTemplate.update("DELETE FROM park WHERE park_id = ?", parkId);
    }

    /*
        This insert uses update() because it does not have a returning clause
     */
    @Override
    public void addParkToState(int parkId, String stateAbbreviation) {
        jdbcTemplate.update("INSERT INTO park_state (park_id, state_abbreviation) VALUES (?,?)",
                parkId, stateAbbreviation);
    }

    @Override
    public void removeParkFromState(int parkId, String stateAbbreviation) {
        jdbcTemplate.update("DELETE FROM park_state WHERE park_id = ? AND state_abbreviation = ?",
                parkId, stateAbbreviation);
    }

    private void removeParkFromAllStates(int parkId) {
        jdbcTemplate.update("DELETE FROM park_state WHERE park_id = ?", parkId);
    }

    private Park mapRowToPark(SqlRowSet rowSet) {
        Park park = new Park();
        park.setParkId( rowSet.getInt("park_id") );
        park.setParkName( rowSet.getString("park_name") );
        park.setHasCamping( rowSet.getBoolean("has_camping") );
        park.setArea( rowSet.getDouble("area") );
        if (rowSet.getDate("date_established") != null) {
            park.setDateEstablished(rowSet.getDate("date_established").toLocalDate() );
        }
        return park;
    }
}
