package com.techelevator.contacts.dao;

import com.techelevator.contacts.model.Phone;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcPhoneDao implements PhoneDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcPhoneDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Phone> getAllPhoneNumbersForUser(int personId) {
        List<Phone> phoneList = new ArrayList<Phone>();
        String sql = "SELECT phone.phone_id, phone_number, phone_type, other_type_description FROM phone " +
                "JOIN person_phone ON phone.phone_id = person_phone.phone_id " +
                "WHERE person_id = ?";
        SqlRowSet returnedRows = jdbcTemplate.queryForRowSet(sql, personId);
        while (returnedRows.next()) {
            Phone phoneFromCurrentRow = mapRowToPhone(returnedRows);
            phoneList.add(phoneFromCurrentRow);
        }
        return phoneList;
    }

    @Override
    public Phone getPhone(int phoneId) {
        Phone phone = null;

        String sql = "SELECT phone.phone_id, phone_number, phone_type, other_type_description FROM phone " +
                "WHERE phone_id = ?";
        SqlRowSet returnedRow = jdbcTemplate.queryForRowSet(sql, phoneId);
        if (returnedRow.next()) {
            phone = mapRowToPhone(returnedRow);
        }

        return phone;
    }

    @Override
    public Phone addPhoneForPerson(Phone phone, int personId) {
        // Create the phone entry
        int newPhoneId = createPhone(phone);
        // Set the generated id onto the phone object
        phone.setPhoneId(newPhoneId);

        // Add the Person Id and the Phone Id to Join table
        addPersonPhoneJoin(newPhoneId, personId);

        // return the phone
        return phone;
    }

    private int createPhone(Phone phone) {
        String sql = "INSERT INTO phone (phone_number, phone_type, other_type_description) " +
                "VALUES (?, ?, ?) RETURNING phone_id";
        Integer newPhoneId = jdbcTemplate.queryForObject(sql, Integer.class,
                phone.getPhoneNumber(), phone.getPhoneType(), phone.getOtherTypeDescription());
        return newPhoneId;
    }

    private void addPersonPhoneJoin(int phoneId, int personId) {
        String sql = "INSERT INTO person_phone (person_id, phone_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, personId, phoneId);
    }

    @Override
    public void updatePhone(Phone phone) {
        String sql = "UPDATE phone " +
                "SET phone_number = ?, phone_type = ?, other_type_description = ?" +
                "WHERE phone_id = ?";
        jdbcTemplate.update(sql, phone.getPhoneNumber(), phone.getPhoneType(), phone.getOtherTypeDescription(), phone.getPhoneId());
    }

    @Override
    public void deletePhoneFromPerson(int phoneId, int personId) {
        String sql = "DELETE FROM person_phone WHERE person_id = ? AND phone_id = ?";
        jdbcTemplate.update(sql, personId, phoneId);
    }



    private Phone mapRowToPhone(SqlRowSet currentRow) {
        Phone phone = new Phone();
        phone.setPhoneId( currentRow.getInt("phone_id") );
        phone.setPhoneNumber( currentRow.getString("phone_number") );
        phone.setPhoneType( currentRow.getString("phone_type") );
        phone.setOtherTypeDescription( currentRow.getString("other_type_description") );
        return phone;
    }
}
