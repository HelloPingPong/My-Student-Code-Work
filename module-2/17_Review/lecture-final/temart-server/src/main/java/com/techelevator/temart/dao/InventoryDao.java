package com.techelevator.temart.dao;


import com.techelevator.temart.model.Product;
import com.techelevator.temart.model.Wishlist;

import java.util.List;

public interface InventoryDao {

    List<Product> getAllProducts();
    Wishlist createWishlist(Wishlist wishlist);

}
