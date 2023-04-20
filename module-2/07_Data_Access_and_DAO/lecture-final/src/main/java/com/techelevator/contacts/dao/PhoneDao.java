package com.techelevator.contacts.dao;

import com.techelevator.contacts.model.Phone;

import java.util.List;

public interface PhoneDao {

    List<Phone> getAllPhoneNumbersForUser(int personId);
    Phone getPhone(int phoneId);
    Phone addPhoneForPerson(Phone phone, int personId);
    void updatePhone(Phone phone);
    void deletePhoneFromPerson(int phoneId, int personId);

}
