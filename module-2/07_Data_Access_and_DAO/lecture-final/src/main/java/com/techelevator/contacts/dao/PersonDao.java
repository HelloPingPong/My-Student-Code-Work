package com.techelevator.contacts.dao;

import com.techelevator.contacts.model.Person;

import java.util.List;

public interface PersonDao {

    List<Person> getAllPersons();
    Person getPersonById(int id);
    Person createPerson(Person person);
    void updatePerson(Person person);
    void deletePerson(int personId);

}
