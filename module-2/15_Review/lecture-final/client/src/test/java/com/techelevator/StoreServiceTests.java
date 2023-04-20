package com.techelevator;

import com.techelevator.model.Product;
import com.techelevator.services.StoreService;
import org.junit.*;

import java.util.List;

public class StoreServiceTests {

    private StoreService storeService;

    @Before
    public void setup() {
        storeService = new StoreService();
    }

    @Test
    public void getAllProducts() {
        //TODO: Remove this test before release
        List<Product> products = storeService.getAllProducts();
        Assert.assertEquals(5, products.size());
    }
}
