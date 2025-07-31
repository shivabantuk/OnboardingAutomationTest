package CoreJaveHometaskLanguageConstructs;

import java.util.Scanner;

public class SumOfTheNumbers {
    public static void main(String[] args) {
        //10
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Your String: ");

        String s = input.nextLine();
        char[] ch = s.toCharArray();
        int sum =0;
        for(char c : ch) {
            if(c>=97 && c<=122) {

            }
            else
            {
                int d = Integer.parseInt(String.valueOf(c));
                sum += d;
            }
        }
        System.out.println(sum);
    }
}
