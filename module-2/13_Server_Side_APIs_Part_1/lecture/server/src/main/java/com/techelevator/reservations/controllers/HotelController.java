package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.MemoryHotelDao;
import com.techelevator.reservations.dao.MemoryReservationDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController //Notation that designates this as recognizable by a controller
public class HotelController {

    private HotelDao hotelDao;
    private ReservationDao reservationDao;

    public HotelController() {
        this.hotelDao = new MemoryHotelDao();
        this.reservationDao = new MemoryReservationDao(hotelDao);
    }
// requestmapping is telling dispatcher where to look and what to look for
    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */
    @RequestMapping(path="/hotels", method=RequestMethod.GET) // indicates which URLS and What type of request this method should call for
    // tells spring "if you get a url ending in this, and it has a GET url method, run this java method. you're mapping a request.
    public List<Hotel> list(@RequestParam(required = false, defaultValue = "") String state,
                            @RequestParam(required = false) String city,
                            @RequestParam(required = false, defaultValue = "0") double maxCost){
        List<Hotel> filteredHotels = new ArrayList<>();

        List<Hotel> hotels = hotelDao.list();
        if (city == null && state.length() == 0 && maxCost == 0.0) {
            return hotels;
        }

        if (state.length() > 0) {
            for (Hotel hotel : hotels) {
                if (hotel.getAddress().getState().equalsIgnoreCase(state)) {
                    filteredHotels.remove(hotel);
                }
            }
        }

        return filteredHotels;
        // returns that list of hotels - request parameter tells it to look in the query string for specific parameters.
        // the required = false is built in and prevents problems from lacking a variable.
        // just sets the default to null.
        //defaultValue makes it return empty
        //return hotelDao.list(); // retrieves that list of hotels from that data source or database
    }

    /**
     * Return hotel information
     *
     * @param id (Path) the id of the hotel
     * @return all info for a given hotel
     */
    @RequestMapping(path="/hotels/{id}", method=RequestMethod.GET) //we're saying after hotels/ anything could be ID. {} is essentially a placeholder
    public Hotel get(@PathVariable int id) { // get is just the name of the method. we need to identify where the id variable is coming from
        //PathVariable is saying "WHATEVER IS AT THIS URL, PASS IT ALONG AS THE id VARIABLE. everything after the hotels/ goes into int id
        return hotelDao.get(id);
    }

    /**
     * Return All Reservations
     *
     * @return a list of all reservations in the system
     */
    @RequestMapping(path="/reservations", method=RequestMethod.GET)
    public List<Reservation> listReservations() {
        return reservationDao.findAll();
    }

    /**
     * Return Reservation details
     *
     * @param id (Path) the id of the reservation
     * @return return the details for a given reservation
     */
    @RequestMapping(path="/reservations/{id}", method=RequestMethod.GET)
    public Reservation getReservationByID(@PathVariable int id) {
        return reservationDao.get(id);
    }

    /**
     * Return All Reservation for a given hotel
     *
     * @param id (Path) the id of the hotel
     * @return return the details for a given reservation
     */
    // these are not special methods. the same ones we wrote in week 2. we're only annotating parts to tell springboot what to do with it
    @RequestMapping(path="/hotels/{id}/reservations", method=RequestMethod.GET) // there can only be this one path for GET for the entire application. we can use the same path with a different URL method though
    public List<Reservation> getReservationsForHotel(@PathVariable("id") int hotelId) { // got to the path, look for ID, and make it this variable. then we could name this whatever we want without changing the path name.
        return reservationDao.findByHotel(hotelId);
    }

    /**
     * Add a reservation to a given hotel
     *
     * @param id (Path) the id of the hotel
     * @param reservation (RequestBody) the details of the new reservation
     * @return return the details for a given reservation
     */
// since we are adding a reservation, we need to POST
    @RequestMapping(path="/hotels/{id}/reservations", method=RequestMethod.POST)
    public Reservation addReservation(@RequestBody Reservation reservation, @PathVariable("id") int hotelId) { //This is gonna look in the body since that's where JSON POSTS are.
        return reservationDao.create(reservation, hotelId); // telling it, that JSON you've got and held? yeah heres where to find it, and now take it, pass it through this method, and instantiate it into an object
    }

}
