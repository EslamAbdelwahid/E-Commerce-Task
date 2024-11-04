import java.util.*;
public class ShippingService {
    public static void displayShippableItems(List<Shippable> shippableItems){
        System.out.println("** Shipment notice **");
        Map<Shippable, Integer> items = new HashMap<>();
        shippableItems.forEach((item) ->
                items.put(item, items.getOrDefault(item, 0) + 1)
        );
        double totalWeight = 0;

        for (Map.Entry<Shippable, Integer> entry : items.entrySet()) {
            Shippable product = entry.getKey();
            Integer quantity = entry.getValue();

            System.out.println(quantity + "x " + product.getName() + "         \t" + product.getWeight() * quantity + "g");
            totalWeight += product.getWeight() * quantity;
        }
        double totalWeightInKg = totalWeight / 1000.0;
        System.out.println("Total package weight: " + totalWeightInKg + " kg");
        System.out.println();
    }
}
