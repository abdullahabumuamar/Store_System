

public class Product {
    public int id;
    public int quantity;
    public String name;
    public double price;
    public ProductType type;

    public Product(int id, int quantity, String name, double price, ProductType type) {
        this.id = id;
        this.quantity = quantity;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    @Override
    public String toString() {
        return "item{" +
                "id = " + id +
                ", quantity = " + quantity +
                ", name = " + name +
                ", price = " + price +
                ", type = " + type +
                '}';
    }

    public String toString2() {
        return check(id, "Item no") + check(name, "Item name") + check(quantity, "Available quantity") + check(price, "Item price") + check(type.toString().substring(0, type.toString().indexOf("{")), "Item type") + "\n";
    }

    public String check(Object content, String title){
        String content1 = content.toString();
        int space = title.length() - content1.length();
        if(space > 0){
            for (int i = 0; i < space; i++){
                content1 = content1 + " ";
            }
        }
        return content1 + " \t ";
    }
}
