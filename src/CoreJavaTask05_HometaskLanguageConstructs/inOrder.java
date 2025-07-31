package CoreJavaTask05_HometaskLanguageConstructs;

public class inOrder {
    public static void main(String[] args) {
        inOrder(10,20,10,true);

    }
    public static void inOrder(int a, int b, int c, boolean bOk){
        if(bOk)
        {
            if(c>b)
            {
                System.out.println("True");
            }
            else
                {
                System.out.println("False");
                }
        }
        else
        {
            if(b>a && c>b)
            {
                System.out.println("True");
            }
            else
            {
                System.out.println("False");
            }
        }


    }

}
