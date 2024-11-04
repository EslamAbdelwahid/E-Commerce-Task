import java.time.LocalDate;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Create products
        Cheese cheese = new Cheese("Rodes", 10,5.99, LocalDate.now().plusDays(30), 0.5);
        TV tv = new TV("Samsung", 5, 499.99, 15.0);
        MobileScratchCard scratchCard = new MobileScratchCard("Vodafone", 10, 10.0);

        // Create customer
        Customer customer = new Customer("Islam", 30000);

        // Add products
        try {
            customer.getCart().addProduct(cheese, 2);
            customer.getCart().addProduct(tv, 1);
            customer.getCart().addProduct(scratchCard, 3);
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding product to cart: " + e.getMessage());
        }
        // Perform checkout
        Checkout checkout = new Checkout();
        try {
            checkout.checkout(customer);
        } catch (IllegalStateException e) {
            System.out.println("Checkout error: " + e.getMessage());
        }
    }
}