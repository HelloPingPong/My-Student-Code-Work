package com.techelevator.chucknorris;

import org.springframework.web.client.RestTemplate;

public class Joker {

    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();

        Joke joke = restTemplate.getForObject("https://api.chucknorris.io/jokes/random?category=dev", Joke.class);

        System.out.println(joke);

    }
}
