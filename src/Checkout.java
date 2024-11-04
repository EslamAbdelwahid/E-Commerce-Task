import java.util.*;
public class Checkout {
    public static final double shippingRate = 1.5;
    public void checkout(Customer customer){
        Cart cart = customer.getCart();
        if(cart.isEmpty()){
            throw new IllegalStateException("Card is empty");
        }
        Map<Product, Integer> items = cart.getItems();
        double subTotal = 0;
        double shippingFees = 0;
        List<Shippable> itemsToShipped = new ArrayList<>();
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product product = entry.getKey();
            Integer quantity = entry.getValue();
            if(product.isExpired()){
                throw new IllegalStateException("product " + product.getName() + " is expired");
            }
            if(quantity > product.getQuantity()){
                throw new IllegalStateException("product " + product.getName() + " is out of stock");
            }
            subTotal += product.getPrice() * quantity;
            if(product instanceof Shippable){
                shippingFees += (product.getQuantity() * ((Shippable) product).getWeight() * shippingRate);
                for(int i = 0;i < product.getQuantity();++i){
                    itemsToShipped.add((Shippable) product);
                }
            }
        }
        double totalPrices = subTotal + shippingFees;
        if(totalPrices > customer.getBalance()){
            throw new IllegalStateException("insufficient balance");
        }

        customer.setBalance(customer.getBalance() - totalPrices);

        ShippingService.displayShippableItems(itemsToShipped);

        System.out.println("** Checkout receipt **");
        for(Map.Entry<Product, Integer> entry : items.entrySet()){
            Product product = entry.getKey();
            Integer quantity = entry.getValue();
            System.out.println(quantity + "x " + product.getName() + "          \t" + quantity * product.getPrice());
        }
        System.out.println("------------------------------------");
        System.out.println("subtotal  \t" + subTotal);
        System.out.println("shipping  \t" + shippingFees);
        System.out.println("Amount    \t" + totalPrices);

    }

}
