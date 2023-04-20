package com.techelevator.contacts;

import com.techelevator.contacts.dao.JdbcPersonDao;
import com.techelevator.contacts.dao.JdbcPhoneDao;
import com.techelevator.contacts.dao.PersonDao;
import com.techelevator.contacts.dao.PhoneDao;
import com.techelevator.contacts.model.Person;
import com.techelevator.contacts.model.Phone;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;
import java.util.Scanner;

public class PhoneDemo {

    private final Scanner in = new Scanner(System.in);
    private BasicDataSource dataSource;
    private PersonDao personDao;

    public PhoneDemo() {
        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/contacts");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");
        personDao =new JdbcPersonDao(dataSource);
    }

    public void run() {
        int personId = getPersonIdFromUser();

        PhoneDao phoneDao = new JdbcPhoneDao(dataSource);

        System.out.println( phoneDao.getAllPhoneNumbersForUser( personId) );

        Phone phone4 = phoneDao.getPhone(4);

        phone4.setPhoneNumber("222-222-2222");

        phoneDao.updatePhone( phone4 );


    }

    private int getPersonIdFromUser() {
        List<Person> persons = personDao.getAllPersons();
        for (Person person: persons) {
            System.out.println(person.getPersonId() + ") " + person.getFirstName() + " " + person.getLastName());
        }
        System.out.print("Select person by id >>>");
        String userInput = in.nextLine();
        return Integer.parseInt(userInput);
    }


    public static void main(String[] args) {
        new PhoneDemo().run();
    }

}
