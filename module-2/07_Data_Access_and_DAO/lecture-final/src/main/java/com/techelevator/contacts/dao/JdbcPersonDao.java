package com.techelevator.contacts.dao;

import com.techelevator.contacts.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/*
    1. Determine the query in pgAdmin - determine input (parameters) and how
       may results you can expect (nothing, 0-to-many-rows, a single generated id)
    2. Call jdbcTemplate
        If 0-to-many rows as result use queryForRowSet()
        If generated id as a result use queryForObject()
        If nothing as a result use update()
    3a. If updated() then you are done
    3b. If queryForObject() then store that object and you are done
    3c. If queryForRowSet(), then a SqlRowSet is returned and you must process it
    4. Call next() in a while loop.  If next() returns true map that row to an object.  If next() returns
       false you are done.
    5. repeat 4 until next() is false
 */
public class JdbcPersonDao implements PersonDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcPersonDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Person> getAllPersons() {
        List<Person> personsFromDatabase = new ArrayList<Person>();
        String sql = "SELECT person_id, first_name, last_name, date_modified FROM person";
        SqlRowSet rowsReturned = jdbcTemplate.queryForRowSet(sql);

        while (rowsReturned.next()) {
            Person personFromCurrentRow = mapRowToPerson( rowsReturned );
            personsFromDatabase.add( personFromCurrentRow );
        }

        return personsFromDatabase;
    }

    @Override
    public Person getPersonById(int id) {
        Person person = null;

        String sql = "SELECT person_id, first_name, last_name, date_modified FROM person " +
                    "WHERE person_id = ?";

        SqlRowSet rowReturned = jdbcTemplate.queryForRowSet(sql, id);

        if (rowReturned.next()) {
            person = mapRowToPerson( rowReturned );
        }

        return person;
    }

    @Override
    public Person createPerson(Person person) {
        String sql = "INSERT INTO person (first_name, last_name, date_modified) VALUES (?,?,?) RETURNING person_id";

        Integer newPersonId = jdbcTemplate.queryForObject(sql, Integer.class, person.getFirstName(),
                person.getLastName(), person.getDateModified());

        person.setPersonId( newPersonId );

        return person;
    }

    @Override
    public void updatePerson(Person person) {
        String sql = "UPDATE person " +
                     "SET first_name = ?, last_name = ? " +
                     "WHERE person_id = ?";
        jdbcTemplate.update(sql, person.getFirstName(), person.getLastName(), person.getPersonId() );
    }

    @Override
    public void deletePerson(int personId) {
        jdbcTemplate.update("DELETE FROM person WHERE person_id = ?", personId);
    }


    private Person mapRowToPerson(SqlRowSet row) {
        Person person = new Person();
        person.setPersonId( row.getInt("person_id") );
        person.setFirstName( row.getString("first_name") );
        person.setLastName( row.getString("last_name") );
        if ( row.getTimestamp("date_modified") != null) {
            person.setDateModified( row.getTimestamp("date_modified").toLocalDateTime() );
        }
        return person;
    }
}
