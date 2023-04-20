package com.techelevator.store.controller;

import com.techelevator.store.dao.InventoryDao;
import com.techelevator.store.dao.JdbcInventoryDao;
import com.techelevator.store.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/products")
public class InventoryController {

    private InventoryDao inventoryDao;

    public InventoryController(InventoryDao inventoryDao) {
        this.inventoryDao = inventoryDao;
    }

    @RequestMapping(path="", method=RequestMethod.GET)
    public List<Product> list() {
        return inventoryDao.getAllProducts();
    }

}
