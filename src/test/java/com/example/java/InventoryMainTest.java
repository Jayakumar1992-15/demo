package com.example.java;

import org.junit.Test;
import com.example.java.InventoryManager.InventoryMain;
import com.example.java.InventoryManager.InventoryManager;
import com.example.java.InventoryManager.Product;

import org.junit.Before;
import static org.junit.Assert.*;

public class InventoryMainTest {
    
    private InventoryManager manager;
    
    @Before
    public void setUp() {
        manager = new InventoryManager();
    }

    // Main execution tests
    @Test
    public void testMainExecutesWithoutException() {
        try {
            InventoryMain.main(new String[] {});
        } catch (Exception e) {
            fail("Main method threw an exception: " + e.getMessage());
        }
    }

    // Product creation tests
    @Test
    public void testProductCreationWithValidData() {
        Product product = new Product(1, "Laptop", 10);
        
        assertNotNull("Product should not be null", product);
        assertEquals("Product id should be 1", 1, product.getId());
        assertEquals("Product name should be Laptop", "Laptop", product.getName());
        assertEquals("Product quantity should be 10", 10, product.getQuantity());
    }

    @Test
    public void testProductToString() {
        Product product = new Product(1, "Laptop", 10);
        String expected = "Product{id=1, name='Laptop', quantity=10}";
        assertEquals("Product toString format should match", expected, product.toString());
    }

    // InventoryManager add product tests
    @Test
    public void testAddSingleProduct() {
        Product product = new Product(1, "Laptop", 10);
        manager.addProduct(product);
        
        Product retrieved = manager.getProduct(1);
        assertNotNull("Product should be retrievable after adding", retrieved);
        assertEquals("Retrieved product should have id 1", 1, retrieved.getId());
    }

    @Test
    public void testAddMultipleProducts() {
        Product p1 = new Product(1, "Laptop", 10);
        Product p2 = new Product(2, "Phone", 20);
        Product p3 = new Product(3, "Tablet", 15);
        
        manager.addProduct(p1);
        manager.addProduct(p2);
        manager.addProduct(p3);
        
        assertNotNull("Product 1 should exist", manager.getProduct(1));
        assertNotNull("Product 2 should exist", manager.getProduct(2));
        assertNotNull("Product 3 should exist", manager.getProduct(3));
    }

    // Update quantity tests
    @Test
    public void testUpdateQuantityForExistingProduct() {
        Product product = new Product(2, "Phone", 20);
        manager.addProduct(product);
        
        boolean result = manager.updateProductQuantity(2, 25);
        
        assertTrue("Update should return true for existing product", result);
        assertEquals("Product quantity should be updated to 25", 25, manager.getProduct(2).getQuantity());
    }

    @Test
    public void testUpdateQuantityForNonexistentProduct() {
        boolean result = manager.updateProductQuantity(999, 25);
        
        assertFalse("Update should return false for non-existent product", result);
    }

    @Test
    public void testUpdateQuantityToZero() {
        Product product = new Product(1, "Laptop", 10);
        manager.addProduct(product);
        
        boolean result = manager.updateProductQuantity(1, 0);
        
        assertTrue("Should allow updating quantity to 0", result);
        assertEquals("Quantity should be 0", 0, manager.getProduct(1).getQuantity());
    }

    // Remove product tests
    @Test
    public void testRemoveExistingProduct() {
        Product product = new Product(1, "Laptop", 10);
        manager.addProduct(product);
        
        boolean result = manager.removeProduct(1);
        
        assertTrue("Remove should return true for existing product", result);
        assertNull("Product should be null after removal", manager.getProduct(1));
    }

    @Test
    public void testRemoveNonexistentProduct() {
        boolean result = manager.removeProduct(999);
        
        assertFalse("Remove should return false for non-existent product", result);
    }

    @Test
    public void testRemoveProductDoesNotAffectOthers() {
        manager.addProduct(new Product(1, "Laptop", 10));
        manager.addProduct(new Product(2, "Phone", 20));
        
        manager.removeProduct(1);
        
        assertNull("Product 1 should be removed", manager.getProduct(1));
        assertNotNull("Product 2 should still exist", manager.getProduct(2));
    }

    // Edge case tests
    @Test
    public void testAddProductWithSameIdOverwrites() {
        Product p1 = new Product(1, "Laptop", 10);
        Product p2 = new Product(1, "Phone", 20);
        
        manager.addProduct(p1);
        manager.addProduct(p2);
        
        assertEquals("Newer product should overwrite", "Phone", manager.getProduct(1).getName());
        assertEquals("Newer product quantity should be 20", 20, manager.getProduct(1).getQuantity());
    }
}