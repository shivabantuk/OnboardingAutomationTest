package Java8Task04_Hometask_Consumer_Supplier;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(new Product("Laptop", 1200, "Electronics", "Standard"),
                new Product("Pen", 50, "Stationery", "Standard"),
                new Product("Smartphone", 1500, "Electronics", "Standard"));

        //1
        Consumer<Product> print = PrintProduct.getPrinter("Console");
        products.forEach(print);

        //2
       Consumer<Product> gradeupdate = ConsumerToUpdateGrade.getGradeUpdate();
        products.forEach(gradeupdate);
        System.out.println("Updategrades");
        products.forEach(print);


    }
}
