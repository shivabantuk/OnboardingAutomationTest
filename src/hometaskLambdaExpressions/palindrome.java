package hometaskLambdaExpressions;

import java.util.Scanner;
import java.util.function.Predicate;

public class palindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String name = input.nextLine();
        String n = new StringBuilder(name).reverse().toString();
        if(name.equals(n)){
            System.out.println("palindrome");
        }
        else {
            System.out.println("not palindrome");
        }
        //Lambda Expression

        Predicate<String> isPalindrome = str -> str.equals(new  StringBuilder(str).reverse().toString());
        String lambdaInput = "madam";
        if(isPalindrome.test(lambdaInput)){
            System.out.println("palindrome");
        }
        else
        {
            System.out.println("not palindrome");
        }
    }
}


