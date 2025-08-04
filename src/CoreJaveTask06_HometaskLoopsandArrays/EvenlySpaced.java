package CoreJaveTask06_HometaskLoopsandArrays;

public class EvenlySpaced {
    public static void main(String[] args) {
        evenlySpaced(2,3,6);

    }
    public static void evenlySpaced(int a, int b, int c){

        int ab = a-b;
        int bc = b-c;
        if(Math.abs(ab) == Math.abs(bc))
        {
            System.out.println("True");
        }
        else
            {
            System.out.println("False");
            }

    }

}
