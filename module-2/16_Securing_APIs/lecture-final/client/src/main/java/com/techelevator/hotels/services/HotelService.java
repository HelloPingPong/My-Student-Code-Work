package com.techelevator.hotels.services;

import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Reservation;
import com.techelevator.util.BasicLogger;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class HotelService {

    private static final String API_BASE_URL = "http://localhost:8080/";
    private final RestTemplate restTemplate = new RestTemplate();

    private String authToken = null;

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    /*
        Example when doing a GET or DELETE request
     */
    /**
     * List all reservations in the hotel reservation system
     */
    public Reservation[] listReservations() {
        Reservation[] reservations = null;

        // Create the HttpHeaders
        HttpHeaders headers = new HttpHeaders();
        // Set the BearerAuth with the token
        headers.setBearerAuth(authToken);
        // Create the HttpEntity as Void (GET/DELETE only) and pass it the headers
        HttpEntity<Void> entityForGet = new HttpEntity<Void>(headers);

        // Use exchange method (when GET/DELETE and token is required) to call the API
        ResponseEntity<Reservation[]> response = restTemplate.exchange(
                API_BASE_URL + "reservations",  // URL
                HttpMethod.GET,                     // HttpMethod  (GET, POST, PUT, or DELETE)
                entityForGet,                       // HttpEntity with BearerAuth set to the token in the header
                Reservation[].class);               // Data Type of the response

        reservations = response.getBody();  // getBody() retrieves the deserialized object(s) from the response ResponseEntity

        return reservations;
    }

    /*
        Example when doing a POST or PUT request
     */
    /**
     * Create a new reservation in the hotel reservation system
     */
    public Reservation addReservation(Reservation newReservation) {
        Reservation returnedReservation = null;

        // Create the Headers
        HttpHeaders headers = new HttpHeaders();
        // Set the Content Type AND the BearerAuth header
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(authToken);
        // Create the HttpEntity with the message body type and pass it the object for the message body and the headers
        HttpEntity<Reservation> entityWithMessageBody = new HttpEntity<Reservation>(newReservation, headers);

        // Use exchange to do the request (for POST and PUT can use the postForObject() and put() methods instead)
        ResponseEntity<Reservation> response = restTemplate.exchange(API_BASE_URL + "reservations",
                HttpMethod.POST, entityWithMessageBody, Reservation.class);

        // Call getBody() on the returned ResponseEntity to get the deserialized class
        returnedReservation = response.getBody();

        return returnedReservation;
    }

    
    /**
     * Updates an existing reservation by replacing the old one with a new reservation
     */
    public boolean updateReservation(Reservation updatedReservation) {
        boolean success = false;
        try {
            restTemplate.put(API_BASE_URL + "reservations/" + updatedReservation.getId(),
                    makeReservationEntity(updatedReservation));
            success = true;
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return success;
    }

    /**
     * Delete an existing reservation
     */
    public boolean deleteReservation(int id) {
        boolean success = false;
        try {
            restTemplate.exchange(API_BASE_URL + "reservations/" + id, HttpMethod.DELETE,
                    makeAuthEntity(), Void.class);
            success = true;
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return success;
    }

    /**
     * List all hotels in the system
     */
    public Hotel[] listHotels() {
        Hotel[] hotels = null;
        try {
            ResponseEntity<Hotel[]> response = restTemplate.exchange(API_BASE_URL + "hotels", HttpMethod.GET,
                            makeAuthEntity(), Hotel[].class);
            hotels = response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return hotels;
    }


    /**
     * List all reservations by hotel id.
     */
    public Reservation[] listReservationsByHotel(int hotelId) {
        Reservation[] reservations = null;
        try {
            ResponseEntity<Reservation[]> response =
                    restTemplate.exchange(API_BASE_URL + "hotels/" + hotelId + "/reservations",
                            HttpMethod.GET, makeAuthEntity(), Reservation[].class);
            reservations = response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservations;
    }

    /**
     * Find a single reservation by the reservationId
     */
    public Reservation getReservation(int reservationId) {
        Reservation reservation = null;
        try {
            ResponseEntity<Reservation> response =
                    restTemplate.exchange(API_BASE_URL + "reservations/" + reservationId,
                            HttpMethod.GET, makeAuthEntity(), Reservation.class);
            reservation = response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservation;
    }

    /**
     * Creates a new HttpEntity with the `Authorization: Bearer:` header and a reservation request body
     */
    private HttpEntity<Reservation> makeReservationEntity(Reservation reservation) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(reservation, headers);
    }

    /**
     * Returns an HttpEntity with the `Authorization: Bearer:` header
     */
    private HttpEntity<Void> makeAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(headers);
    }

}
