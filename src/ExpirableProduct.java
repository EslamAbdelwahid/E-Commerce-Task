import java.time.LocalDate;
public class ExpirableProduct extends Product{
    private LocalDate expirationDate;

    public ExpirableProduct(String name, int quantity, double price, LocalDate expirationDate) {
        super(name, quantity, price);
        this.expirationDate = expirationDate;
    }

    public ExpirableProduct() {
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expirationDate);
    }
}

