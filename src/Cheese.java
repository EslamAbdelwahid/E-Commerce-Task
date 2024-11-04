import java.time.LocalDate;

public class Cheese extends ExpirableProduct implements Shippable{
    private double weight;

    public Cheese(String name, int quantity, double price, LocalDate expirationDate, double weight) {
        super(name, quantity, price, expirationDate);
        this.weight = weight;
    }

    public Cheese() {
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
