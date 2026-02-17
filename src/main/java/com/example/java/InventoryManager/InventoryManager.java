//inventory manager class that uses a map and adds,removes,lists and updates products
package com.example.java.InventoryManager;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    private Map<Integer, Product> inventory;

    public InventoryManager() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getId(), product);
    }

    public boolean removeProduct(int id) {
        return inventory.remove(id) != null;
    }

    public Product getProduct(int id) {
        return inventory.get(id);
    }

    public boolean updateProductQuantity(int id, int quantity) {
        Product product = inventory.get(id);
        if (product != null) {
            product.setQuantity(quantity);
            return true;
        }
        return false;
    }

    public void listProducts() {
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }
}