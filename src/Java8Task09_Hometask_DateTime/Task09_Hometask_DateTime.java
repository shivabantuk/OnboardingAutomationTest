package Java8Task09_Hometask_DateTime;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;
import java.util.function.Predicate;

public class Task09_Hometask_DateTime {

    public static void main(String[] args) {

        Predicate<LocalDate> isYesterday =  date -> date.equals(LocalDate.now().minusDays(1));
        LocalDate testdate = LocalDate.now().minusDays(1);
       System.out.println( isYesterday.test(testdate));

       //4

        Function<LocalDate, Integer> calculateage = dob -> {        LocalDate today = LocalDate.now();
            LocalDate DOB = LocalDate.of(1998, 03, 28);
            Period period = Period.between(DOB, today);
            return period.getYears();

        };
        LocalDate today = LocalDate.now();
        System.out.println(calculateage.apply(today));


    }
}
