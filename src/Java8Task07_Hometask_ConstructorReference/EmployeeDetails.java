package Java8Task07_Hometask_ConstructorReference;

public class EmployeeDetails {

    String name;
    String accountNumber;
    double salary;
    public EmployeeDetails(String name, String accountNumber, double salary) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.salary = salary;
    }

    public void getdetails() {
        System.out.println("Name : " + name);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Salary : " + salary);

    }

}
