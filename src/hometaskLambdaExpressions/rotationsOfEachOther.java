package hometaskLambdaExpressions;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class rotationsOfEachOther {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name: ");

        String name = sc.next();
        System.out.println("Enter the name2: ");

        String name2 = sc.next();
        char[] ch1 = name.toCharArray();
        char[] ch2 = name2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        if(Arrays.equals(ch1,ch2)){
            System.out.println("rotationsOfEachOther "+name+" "+name2);
        }
        else  {
            System.out.println("not rotationsOfEachOther");
        }

        //




    }
}
