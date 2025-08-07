package Java8Task2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task03_Hometask_FunctionInterface {
    public static void main(String[] args) {

        List<Product> product = Arrays.asList(new Product("pen", 500, "Stationery", "C"), new Product("Laptop", 1000, "electronic", "A")
                ,new Product("Mobile", 1500, "electronic", "B"), new Product("Shoe", 1500, "fashion", "D"));
        double s = product.stream().mapToDouble(p->p.price).sum();
        System.out.println("s=" + s);
        double sum = product.stream().filter(p->p.price > 1000).mapToDouble(p->p.price).sum();
        System.out.println("sum=" + sum);
        double electronicsprices = product.stream().filter(p->p.category.equals("electronic")).mapToDouble(p->p.price).sum();
        System.out.println("electronicsprices=" + electronicsprices);
       double electronicwithgreaterthan1000 =  product.stream().filter(p->p.category.equals("electronic") && p.price > 1000).mapToDouble(p->p.price).sum();

        System.out.println("electronicwithgreaterthan1000=" + electronicwithgreaterthan1000);

    }
}


