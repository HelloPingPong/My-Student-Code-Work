package com.techelevator.contacts;

import com.techelevator.contacts.dao.JdbcPersonDao;
import com.techelevator.contacts.dao.PersonDao;
import com.techelevator.contacts.model.Person;
import org.apache.commons.dbcp2.BasicDataSource;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class ContactsApp {

    private static final Scanner in = new Scanner(System.in);

    public void run() {
        // Create DataSource
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/contacts");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        PersonDao personDao = new JdbcPersonDao(dataSource);

        // Get a list of all persons and show them
        List<Person> personList = personDao.getAllPersons();

        // Get one person by id and display it
        int personId = getPersonIdFromUser();
        Person person = personDao.getPersonById( personId );
        System.out.println(person);

        // Add a person
        Person newPerson = new Person();
        newPerson.setFirstName("TestFirst");
        newPerson.setLastName("TestLast");
        newPerson.setDateModified( LocalDateTime.now() );

        Person returnedFromInsert = personDao.createPerson( newPerson );
        System.out.println(returnedFromInsert);

        // Update the person just added
        returnedFromInsert.setFirstName("UpdatedFirst");
        personDao.updatePerson( returnedFromInsert );

        // Delete a person by id
        personDao.deletePerson( returnedFromInsert.getPersonId() );
    }

    private int getPersonIdFromUser() {
        System.out.print("Person id >>>");
        return Integer.parseInt( in.nextLine() );
    }


    public static void main(String[] args) {
        new ContactsApp().run();
    }
}
