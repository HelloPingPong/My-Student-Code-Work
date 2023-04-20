package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        Bid newBid = new Bid("Test", 10);
        System.out.println( newBid.toString() );

        Bid newBid2 = new Bid("Test", 10);

        if (newBid.equals( newBid2 )) {
            System.out.println("These are the same Bid");
        }


        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");

        generalAuction.placeBid(new Bid("Josh", 1));
        generalAuction.placeBid(new Bid("Fonz", 23));
        generalAuction.placeBid(new Bid("Rick Astley", 13));
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids


        BuyoutAuction buyoutAuction = new BuyoutAuction("Java Book", 20);

        buyoutAuction.placeBid(new Bid("Laura", 10));
        buyoutAuction.placeBid(new Bid("John", 15));
        buyoutAuction.placeBid(new Bid("Rachelle", 22));
        buyoutAuction.placeBid(new Bid("Steve", 8));

        ReserveAuction reserveAuction = new ReserveAuction("Coffee Cup", 50);
        reserveAuction.placeBid(new Bid("Laura", 17));
        reserveAuction.placeBid(new Bid("John", 56));
        reserveAuction.placeBid(new Bid("Rachelle", 22));
        reserveAuction.placeBid(new Bid("Steve", 80));


        /*
            Upcasting - casting to a superclass type is a form of widening, so it is
            implicit
         */
        Auction buyoutAuctionAsAuction = buyoutAuction;

        /*
            Downcasting - casting from a superclass to a subclass type is a form of
            narrowing, so it is explicit and only works if the object can be that
            type
         */
        BuyoutAuction backToBuyoutAuction = (BuyoutAuction) buyoutAuctionAsAuction;


        Auction reserveAuctionAsAuction = reserveAuction;
        /*
            IF downcast to an incompatible type get a ClassCastException
         */
        //BuyoutAuction thisWontWork = (BuyoutAuction) reserveAuctionAsAuction;


        List<Auction> auctions = new ArrayList<Auction>();
        auctions.add(generalAuction);
        auctions.add(buyoutAuction);
        auctions.add(reserveAuction);


        for (Auction currentAuction : auctions) {
            currentAuction.placeBid(new Bid("Matt", 10));
        }
    }
}
