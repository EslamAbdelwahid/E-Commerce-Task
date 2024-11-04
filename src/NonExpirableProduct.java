public class NonExpirableProduct extends Product{
    public NonExpirableProduct(String name, int quantity, double price) {
        super(name, quantity, price);
    }
    public NonExpirableProduct() {
    }
    @Override
    public boolean isExpired() {
        return false;
    }
}
