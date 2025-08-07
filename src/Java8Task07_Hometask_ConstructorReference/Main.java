package Java8Task07_Hometask_ConstructorReference;

import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {


        BiFunction<String , String, EmployeeDetails> createfunction = (name, accountNumber) -> new EmployeeDetails(name, accountNumber, 50000);
        //getdetails
EmployeeDetails employee = createfunction.apply("Shiva", "12345");
employee.getdetails();


    }
}
