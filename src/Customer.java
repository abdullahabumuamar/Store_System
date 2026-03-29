

import java.util.ArrayList;

public class Customer {
    public int id;
    public String name;
    public ArrayList<Cart> cart;

    public Customer(int id, String name, ArrayList<Cart> cart) {
        this.id = id;
        this.name = name;
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id = " + id +
                ", name = " + name +
                ", cart = " + cartToString() +
                '}';
    }

    public String cartToString(){
        String content = "";
        for (int i = 0; i < cart.size(); i++){
            if(i == cart.size() - 1){
                content = content + cart.get(i).toString();
            }else {
                content = content + cart.get(i).toString() + " - ";
            }
        }
        return content;
    }

    public String toCart(){
        String content = "Item no \t Item name \t Available quantity \t Item price \t Item type \n";
        double total = 0.0;
        for (Cart cart1 : cart) {
            content = content + cart1.product.toString2();
            total = total + (cart1.product.price * cart1.count);
        }
        content = content + "Total price: " + total;
        return content;
    }

}
