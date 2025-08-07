package Java8Task04_Hometask_Consumer_Supplier;

import java.util.function.Consumer;

public class ConsumerToUpdateGrade {
    public static Consumer<Product> getGradeUpdate(){

        return product -> {if(product.price > 1000) {
            product.setGrade("Premium");
        }
    };
}
}
