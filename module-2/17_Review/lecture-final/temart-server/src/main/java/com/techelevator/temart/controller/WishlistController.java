package com.techelevator.temart.controller;

import com.techelevator.temart.dao.InventoryDao;
import com.techelevator.temart.dao.UserDao;
import com.techelevator.temart.model.Wishlist;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.time.LocalDateTime;

@PreAuthorize("isAuthenticated()")
@RestController
public class WishlistController {

    private InventoryDao inventoryDao;
    private UserDao userDao;

    public WishlistController(InventoryDao inventoryDao, UserDao userDao) {
        this.inventoryDao = inventoryDao;
        this.userDao = userDao;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path="/wishlists", method = RequestMethod.POST)
    public Wishlist createWishlist(@RequestBody Wishlist wishlist, Principal principal) {
        int loggedInUsersId = userDao.findIdByUsername( principal.getName() );
        if (loggedInUsersId != wishlist.getUserId()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Cannot create wishlist for another user");
        }
        wishlist.setDateCreated(LocalDateTime.now());
        return inventoryDao.createWishlist(wishlist);
    }
}
