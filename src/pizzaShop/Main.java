package pizzaShop;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub


        PizzaBase standard = new PizzaBase("Standard", 3.0);
        PizzaBase soft = new PizzaBase("soft", 4.0);
        Toppings tomato = new Toppings("tomato", 1.0);
        Toppings corn = new Toppings("corn", 2.0);
        Toppings mushroom = new Toppings("mushroom", 2.5);
        List<Toppings> selectedToppings = Arrays.asList(corn, mushroom);
        Pizza pizza = new Pizza(soft, selectedToppings);
        System.out.print("Total cost of pizza: $" + pizza.getCost());
    }

}
