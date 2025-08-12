package Java8Task05_Hometask_BiFunctionalInterfaces;

import java.util.function.BiFunction;

public class Product {

    private String name;
    private double price;
    private String Category;
    private String grade;

    public Product(String name, Double price, String Category, String a) {
        this.name = name;
        this.price = price;
        this.Category = Category;
        this.grade = a;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getCategory() {
        return Category;
    }
    public String getGrade() {
        return grade;
    }


    BiFunction<String, Double, Product> createProduct = (name, price) -> new Product(name, price, "General", "A");

    //BiFunction<Product, Integer, Double> createFunction = (product, quantity) -> product.getPrice() * quantity;
}
