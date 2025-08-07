package Java8Task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        List<Product> products = Arrays.asList(new Product("pen", 500, "Stationery", "C"), new Product("Laptop", 1000, "electronic", "A")
        ,new Product("Mobile", 1500, "electronic", "B"), new Product("Shoe", 1500, "fashion", "D"));
        List<Response> responses = Arrays.asList(new Response("Success", 200, "JSON"),new Response("Created", 201, "XML"), new Response("Bad Request", 400, "JSON"),
                new Response("Unauthorised", 401, "JSON"));

        //1 list of the products if the price is greaterthan 1000/-

        Predicate<Product> priceGreaterThan100 = p->p.price >1000;
        System.out.println("priceGreaterThan100: ");
        products.stream().filter(priceGreaterThan100).forEach(System.out::println);

        //2list of the products if the product is of electronics category.

        Predicate<Product> Category = p->p.category == "electronic";
        products.stream().filter(Category).forEach(System.out::println);
        //3
        Predicate<Product> greaterthan100AndEqualsToelectronics = p->p.price > 100 && p.category.equals("electronic");
        products.stream().filter(greaterthan100AndEqualsToelectronics).forEach(System.out::println);
        //4
        Predicate<Product> greaterthan100orEqualsToelectronics = p->p.price > 100 || p.category.equals("electronic");
        products.stream().filter(greaterthan100orEqualsToelectronics).forEach(System.out::println);
        //5
        Predicate<Product> lessthan100AndEqualsToelectronics = p->p.price > 100 && p.category.equals("electronic");
        products.stream().filter(lessthan100AndEqualsToelectronics).forEach(System.out::println);
        //6
        Predicate<Response> Statuscodeis400  = p->p.statusCode == 400;
        responses.stream().filter(Statuscodeis400).forEach(System.out::println);
        //7
        Predicate<Response> responseJson = p->p.responseBody == "JSON";
        responses.stream().filter(responseJson).forEach(System.out::println);
        //8
        Predicate<Response> status400andJson = p->p.statusCode == 400 && p.responseBody == "JSON";
        responses.stream().filter(status400andJson).forEach(System.out::println);
        //9
        Predicate<Response> status400orJson = p->p.statusCode == 400 || p.responseBody == "JSON";
        responses.stream().filter(status400orJson).forEach(System.out::println);
        //10
        Predicate<Response>  notstatus400andJson = p->p.statusCode != 400 && p.responseBody == "JSON";
        responses.stream().filter(notstatus400andJson).forEach(System.out::println);




    }
}
