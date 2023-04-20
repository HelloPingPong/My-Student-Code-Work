package com.techelevator.temart.inventory;

import java.io.FileNotFoundException;
import java.util.Map;

public interface InventoryBuilder {

    Map<String, Product> getInventory() throws FileNotFoundException;

}
