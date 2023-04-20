package com.techelevator.services;

import com.techelevator.model.Product;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class StoreService {

    private final static String BASE_API_URL = "http://localhost:8080/";
    private final RestTemplate restTemplate = new RestTemplate();

    public List<Product> getAllProducts() {
        String url = BASE_API_URL + "products";
        Product[] products = restTemplate.getForObject(url, Product[].class);
        return Arrays.asList(products);
    }


}
