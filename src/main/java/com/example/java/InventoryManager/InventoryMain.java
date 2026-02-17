// Main method to test the InventoryManager class
package com.example.java.InventoryManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InventoryMain {
    private static final Logger logger = LoggerFactory.getLogger(InventoryMain.class);

    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        // Create products
        Product product1 = new Product(1, "Laptop", 10);
        Product product2 = new Product(2, "Phone", 20);
        Product product3 = new Product(3, "Tablet", 15);

        // Add products to inventory
        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);

        logger.info("Inventory after adding products:");
        manager.listProducts();

        // Update product quantity
        if (manager.updateProductQuantity(2, 25)) {
            logger.info("Inventory after updating quantity of product with id 2:");
        } else {
            logger.warn("Failed to update quantity for product with id 2.");
        }
        manager.listProducts();

        // Remove a product
        if (manager.removeProduct(1)) {
            logger.info("Inventory after removing product with id 1:");
        } else {
            logger.warn("Failed to remove product with id 1.");
        }
        manager.listProducts();
    }
}