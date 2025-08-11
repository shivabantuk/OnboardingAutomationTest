package APITask02_HomeTask_REST_Functional;

public class Task1Main {
    public static void main(String[] args) {

        Task01_HomeTask_Webservices_Functional ct = new  Task01_HomeTask_Webservices_Functional();
        ct.testMethod("Add",10,5);
        ct.testMethod("Sub",10,5);
        ct.testMethod("Multiply",10,5);
        ct.testMethod("Divide",10,5);

    }
}
