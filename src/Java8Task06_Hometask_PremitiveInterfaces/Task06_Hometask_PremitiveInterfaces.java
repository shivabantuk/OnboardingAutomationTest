package Java8Task06_Hometask_PremitiveInterfaces;

import java.util.Random;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;

public class Task06_Hometask_PremitiveInterfaces {
    public static void main(String[] args) {


        //IntPredicate
        IntPredicate isprime = n -> {
            if (n <= 1) return false;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;

        };

        System.out.println(isprime.test(3));

        //IntConsumer
        IntConsumer printsquare = n -> System.out.println("Square: "+ n*n );
        printsquare.accept(3);

        //IntSupplier
        Random rand = new Random();
        IntSupplier randombelow5000 = ()->rand.nextInt(5000);
        System.out.println(randombelow5000.getAsInt());
    }
}
