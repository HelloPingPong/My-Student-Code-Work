package com.techelevator.hotels.services;

import com.techelevator.hotels.model.Country;
import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Review;
import org.springframework.web.client.RestTemplate;

public class HotelService {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String API_BASE_URL = "http://localhost:3000/";

    public Hotel[] listHotels() {
        String url = API_BASE_URL + "hotels";
        Hotel[] hotels = restTemplate.getForObject(url,Hotel[].class);
        return hotels;
    }

    public Review[] listReviews() {
        String url = API_BASE_URL + "reviews";
        Review[] reviews = restTemplate.getForObject(url, Review[].class);
        return reviews;
    }

    public Hotel getHotelById(int id) {
        String url = API_BASE_URL + "hotels/" + id;
        Hotel hotel = restTemplate.getForObject(url, Hotel.class);
        return hotel;
    }

    public Review[] getReviewsByHotelId(int hotelID) {
        String url = API_BASE_URL + "hotels/" + hotelID + "/reviews";
        return restTemplate.getForObject(url, Review[].class);
    }

//    public Review[] getReviewsByHotelId(int hotelID) {
//        return restTemplate.getForObject(API_BASE_URL + "hotels/" + hotelID + "/reviews", Review[].class);
//    }

    public Hotel[] getHotelsByStarRating(int stars) {
        String url = API_BASE_URL + "hotels?stars=" + stars;
        return restTemplate.getForObject(url, Hotel[].class);
    }

    public Country getWithCustomQuery(){
        return restTemplate.getForObject("https://api.country.is/", Country.class);
    }

}
