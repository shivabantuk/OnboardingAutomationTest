package Comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ReverseOrder {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9,10);
        Collections.sort(list, new Comparator<Integer>()
        {
public int  compare(Integer a, Integer b)
    {
        return b.compareTo(a);
    }
        });
        System.out.println(list);
    }
}
