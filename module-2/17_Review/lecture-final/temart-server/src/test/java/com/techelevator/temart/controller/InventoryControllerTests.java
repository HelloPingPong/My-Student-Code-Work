package com.techelevator.temart.controller;

import com.techelevator.temart.dao.mock.MockInventoryDao;
import com.techelevator.temart.model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class InventoryControllerTests {

    private InventoryController inventoryController;

    @Before
    public void setup() {
        inventoryController = new InventoryController(new MockInventoryDao());
    }

    @Test
    public void list_all_products() {
        List<Product> productsReturned = inventoryController.listProducts();
        Assert.assertEquals(5, productsReturned.size());
    }
}
