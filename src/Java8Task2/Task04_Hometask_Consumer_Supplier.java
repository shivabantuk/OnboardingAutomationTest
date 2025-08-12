package Java8Task2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Task04_Hometask_Consumer_Supplier {
    public static void main(String[] args) throws IOException {

        List<Product> product = Arrays.asList(new Product("pen", 500, "Stationery", "C"), new Product("Laptop", 1000, "electronic", "A")
                , new Product("Mobile", 1500, "electronic", "B"), new Product("Shoe", 1500, "fashion", "D"));

        System.out.println();

    }
    public static Consumer<Product> getPrint(boolean printToFile) {
        return product -> { if (printToFile) {
            FileWriter fw = null;
            try {
                fw = new FileWriter("C:\\Users\\ShivaKumarBantu\\IdeaProjects\\pizzashops\\src\\Java8Task2\\ProductFile", true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                fw.write(product.toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        };}}
