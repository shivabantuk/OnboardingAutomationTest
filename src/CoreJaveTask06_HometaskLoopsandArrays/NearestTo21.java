package CoreJaveTask06_HometaskLoopsandArrays;

public class NearestTo21 {
    public static void main(String[] args) {
        nearto21(22,21);

    }
    public static void nearto21(int a, int b){


        if(a>b || b>a && a<=21 || b<=21)
        {
            System.out.println("True");
            if(a>b&&a<=21)
            {
                System.out.println("a is nearst to 21");
            }
            else {
                System.out.println("b is nearst to 21");
            }


        }
        else
        {
            System.out.println("False");
        }


    }
}
