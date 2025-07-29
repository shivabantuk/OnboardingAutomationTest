package pizzaShop;

import java.util.List;

public class Pizza {

    PizzaBase base;
    List<Toppings> toppings;

    public Pizza(PizzaBase base, List<Toppings> toppings) {

        this.base = base;
        this.toppings = toppings;

    }

    public double getCost() {

        double total = base.cost;
        for (Toppings topping : toppings) {
            total += topping.cost;
        }
        return total;

    }

}
