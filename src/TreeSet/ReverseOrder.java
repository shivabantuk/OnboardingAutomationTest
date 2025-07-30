package TreeSet;

import java.util.Comparator;
import java.util.TreeSet;

public class ReverseOrder {
    public static void main(String[] args) {


        TreeSet<Integer> list = new TreeSet<>(Comparator.reverseOrder());
        list.add(2);
        list.add(1);
        list.add(4);
        list.add(3);
        list.add(5);
        System.out.println(list);

    }
}