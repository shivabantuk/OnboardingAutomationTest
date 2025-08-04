package CollectionsTask11;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        GradeManagement gradeManagement = new GradeManagement();
        gradeManagement.addStudent(1, "Alice", new ArrayList<>(Arrays.asList(85.0, 90.0, 78.0)));
        gradeManagement.addStudent(2, "Bob", new ArrayList<>(Arrays.asList(88.0, 92.0, 80.0)));
        gradeManagement.updateGrade(1, new ArrayList<>(Arrays.asList(85.0, 90.0, 78.0)));
        gradeManagement.printAverage(1);
        gradeManagement.printAverage(2);


    }
}
