
public class Shoes implements ProductType {
    String style, color;
    int size;

    public Shoes(String style, String color, int size) {
        this.style = style;
        this.color = color;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Shoes{" +
                "style = " + style +
                ", color = " + color +
                ", size = " + size +
                '}';
    }
}
