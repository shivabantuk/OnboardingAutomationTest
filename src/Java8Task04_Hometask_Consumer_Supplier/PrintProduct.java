package Java8Task04_Hometask_Consumer_Supplier;

import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Consumer;

public class PrintProduct {
    public static Consumer<Product> getPrinter(String printParameter) {
        if ("file".equals(printParameter)) {
            return product -> {


                try (FileWriter writer = new FileWriter("C:\\Users\\ShivaKumarBantu\\IdeaProjects\\pizzashops\\src\\Java8Task04_Hometask_Consumer_Supplier\\product.txt", true)) {
                    try {
                        writer.write(product.toString() + System.lineSeparator());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

            } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            };}

            else {
            return product -> System.out.println(product.toString());
        }}}