package CollectionsTask11;

import java.util.ArrayList;
import java.util.TreeMap;

import static CollectionsTask11.Student.getaverageGrade;

public class GradeManagement {
    private TreeMap<Integer, Student> students = new TreeMap<>();


    public void addStudent(int id, String name, ArrayList<Double> grades) {
        students.put(id, new Student(name, grades));
    }

    public void updateGrade(int id, ArrayList<Double> newGrades) {
        Student student = students.get(id);
        if (student != null) {
            student.setGrades(newGrades);

        }
    }

    public void printAverage(int id) {
        Student student = students.get(id);
        if (student != null) {
            System.out.println(student.getName() + " " + student.getaverageGrade("id"));
        }
    }


}
