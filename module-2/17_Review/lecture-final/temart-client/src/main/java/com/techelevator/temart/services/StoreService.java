package com.techelevator.temart.services;

import com.techelevator.temart.model.AuthenticatedUser;
import com.techelevator.temart.model.Product;
import com.techelevator.temart.model.Wishlist;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class StoreService {

    private String baseApiUrl;
    private AuthenticatedUser currentUser;

    public StoreService(String baseApiUrl, AuthenticatedUser currentUser) {
        this.baseApiUrl = baseApiUrl;
        this.currentUser = currentUser;
    }

    RestTemplate restTemplate = new RestTemplate();

    /*
        The only connection between the client and the server is the
        endpoint (/products) and the web method (GET) and JSON request/response
     */
    public List<Product> getAllProducts() {
        String url = baseApiUrl + "products";
        /*
            2) Makes an HTTP Request to the API Server to get all the products
         */
        Product[] products = restTemplate.getForObject(url, Product[].class);
        /*
            6) The client receives the JSON response from the server and deserializes
               the JSON into an array of Products.
               The Array is then converted into a List<Product> and returned
         */
        return List.of(products);
    }

    public Wishlist addNewWishlist(String newWishlistName) {
        Wishlist newWishlist = new Wishlist();
        newWishlist.setName(newWishlistName);
        newWishlist.setUserId(currentUser.getUser().getId());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(currentUser.getToken());
        HttpEntity<Wishlist> requestEntity = new HttpEntity<Wishlist>(newWishlist, headers);

        ResponseEntity<Wishlist> response = restTemplate.exchange(baseApiUrl + "wishlists", HttpMethod.POST,
                requestEntity, Wishlist.class);
        return response.getBody();
    }

    public void setCurrentUser(AuthenticatedUser currentUser) {
        this.currentUser = currentUser;
    }
}
