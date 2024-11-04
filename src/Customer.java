public class Customer {
    private Cart cart;
    private String name;
    private double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
        cart = new Cart();
    }
    public Customer() {
        this.cart = new Cart();
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart Cart) {
        this.cart = Cart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
