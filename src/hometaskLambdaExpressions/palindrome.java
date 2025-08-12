package hometaskLambdaExpressions;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class palindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String name = input.nextLine();
        String n = new StringBuilder(name).reverse().toString();
        if (name.equals(n)) {
            System.out.println("palindrome");
        } else {
            System.out.println("not palindrome");
        }


        //Lambda Expression

        //1 Palindrome

        Predicate<String> isPalindrome2 = str -> str.equals(new StringBuilder(str).reverse().toString());
        String lambdaInput2 = "madam";
        if (isPalindrome2.test(lambdaInput2)) {
            System.out.println("palindrome");
        } else {
            System.out.println("not palindrome");
        }

        //2 2nd biggest number
        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Optional<Integer> secondmax = num.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        System.out.println(secondmax.get());

        //3 two string are rotational
        BiPredicate<String, String> rotation = (s1, s2) -> s1.length() == s2.length() && (s1 + s1).contains(s2);
        System.out.println(rotation.test("ABCD", "CDBA"));

        //5Compartor
        List<Integer> num2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        num2.sort(Comparator.reverseOrder());
        System.out.println(num2);
        //6
        List<String> characters = Arrays.asList("a", "b", "c", "e", "d", "f", "g", "h");
        characters.sort(Comparator.naturalOrder());
        System.out.println(characters);
    }
}


