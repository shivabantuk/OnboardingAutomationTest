package hometaskLambdaExpressions;

import java.util.Arrays;

public class secondBiggestNumber {
    public static void main(String[] args) {
        int[] numbers  = {1,2,4,5,7,9,4,8,0};
        Arrays.sort(numbers);
        int secondBiggestNumber = numbers[numbers.length-2];
        System.out.println("second biggest number is: " + secondBiggestNumber);
    }
}
