package Java8Task05_Hometask_BiFunctionalInterfaces;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("Apple", 10.0, "Fruit", "A");
        Product product2 = new Product("CoolDrink", 15.0, "Bakery", "B");

        Map<Product, Integer> cart = new HashMap<>();
        cart.put(product1, 3);
        cart.put(product2, 2);

        //Bifunction -> 1

        BiFunction<Product, Integer, Double> costfunction = (product, quantity) -> product.getPrice() * quantity;


        //BiFunction ->2
        double cartprice = 0.0;
        Set s = cart.entrySet();
        Iterator i = s.iterator();
        while (i.hasNext()) {
            Map.Entry<Product, Integer> entry = (Map.Entry<Product, Integer>) i.next();
            cartprice += costfunction.apply(entry.getKey(), entry.getValue());
        }
        System.out.println(cartprice);
    }
}
