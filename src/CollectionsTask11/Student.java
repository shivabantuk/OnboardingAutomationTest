package CollectionsTask11;

import java.util.ArrayList;
import java.util.TreeMap;

public class Student {
    private String name;
    private static ArrayList<Double> grades;

    public Student(String name, ArrayList<Double> grades) {
        this.name = name;
        this.grades = new ArrayList<>(grades);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getGrades() {

        return grades;
    }

    public void setGrades(ArrayList<Double> grades) {
        this.grades = new ArrayList<>(grades);

    }

    public static double getaverageGrade(String name) {
        if (grades.isEmpty())
            return 0.0;
        double sum = 0.0;
        for (Double g : grades) {
            sum += g;
        }

        return sum / grades.size();
    }



}
