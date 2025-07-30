package hometaskLambdaExpressions;

import java.util.Scanner;

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
    }
}


