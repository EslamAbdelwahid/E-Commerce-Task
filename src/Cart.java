import java.util.*;
public class Cart {
    private Map<Product, Integer> items;

    public Cart(Map<Product, Integer> items) {
        this.items = items;
    }
    public Cart() {
        this.items = new HashMap<>();
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public void setItems(Map<Product, Integer> items) {
        this.items = items;
    }

    public void addProduct(Product product, int quantity){
        if(quantity <= 0 || quantity > product.getQuantity()){
            throw new IllegalArgumentException("Invalid quantity");
        }
        items.put(product, items.getOrDefault(product, 0) + quantity);
    }
    public boolean isEmpty(){
        return items.isEmpty();
    }
    public void clear(){
        items.clear();
    }
}
