import java.util.*;
public class ShoppingCart{
    public static void main(String[] args){
        HashMap<String,Double> prices = new HashMap<>();
        prices.put("Laptop",800.0);
        prices.put("Book",20.0);
        prices.put("Pen",2.5);

        LinkedHashMap<String,Double> cart = new LinkedHashMap<>();
        cart.put("Pen",2.5);
        cart.put("Book",20.0);
        cart.put("Laptop",800.0);

        TreeMap<String,Double> sortedByName = new TreeMap<>(cart);
        System.out.println("Prices (hashMap): "+prices);
        System.out.println("Cart (Order add - LinkedHashMap): "+cart);
        System.out.println("Cart sorted by product name (treeMap): "+sortedByName);
    }
}
