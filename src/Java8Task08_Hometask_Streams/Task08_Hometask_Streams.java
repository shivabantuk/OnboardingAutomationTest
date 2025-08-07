package Java8Task08_Hometask_Streams;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class Task08_Hometask_Streams {
    public static void main(String[] args) {
        //1
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.stream().filter(n->n%2==0).collect(Collectors.toList()).forEach(System.out::println);

        //2
        List<Optional<String>> namesOptional = Arrays.asList(Optional.of("John"), Optional.empty(), Optional.of("Jane"), Optional.empty());
        namesOptional.stream().filter(n->n.isPresent()).collect(Collectors.toList()).forEach(System.out::println);

        //3
        List<Employee> employees  = Arrays.asList(new Employee("shiva", 25, "IT", 1500), new Employee("kumar", 26, "NON IT", 1000), new Employee("bantu", 27, "IT", 1050) );
        List<String> s = employees.stream().filter(p->p.department.equals("IT")).sorted(Comparator.comparing(Employee::salary).reversed()).map(p->p.name).collect(Collectors.toList());
        System.out.println(s);

        //4

        LocalDate currentDate = LocalDate.now();
        LocalDate NextNewYear = LocalDate.of(currentDate.getYear()+1, 1,1);
        long daysBetween = ChronoUnit.DAYS.between(currentDate,NextNewYear);
        System.out.println(daysBetween);

        //5
        MathOperation mutlipication = (a, b) ->  a*b;
        int result = mutlipication.operate(2,3);
        System.out.println(result);
    }

    interface MathOperation {
        int operate(int a, int b);
    }



}
