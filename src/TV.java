public class TV extends NonExpirableProduct implements Shippable{
    private double weight;

    public TV(String name, int quantity, double price, double weight) {
        super(name, quantity, price);
        this.weight = weight;
    }

    public TV() {
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
