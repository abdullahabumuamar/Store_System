


public class Cart{
    Product product;
    int count;

    public Cart(Product product, int count) {
        this.product = product;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "product = " + product +
                ": count = " + count +
                '}';
    }
}
