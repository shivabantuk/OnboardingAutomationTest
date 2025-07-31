package CoreJavaTask05_HometaskLanguageConstructs;

public class LotteryTicket {
    public static void main(String[] args) {
        ticket(5,5,2);

    }
    public static int ticket(int a,int b, int c){
        int ab = a+b;
        int bc =b+c;
        int ac = a+c;
        if(ab==10||bc==10||ac==10)
        {
            System.out.println(10);
        }
        else if(ab == 10+bc||ab == 10+ac)
        {
            System.out.println(5);
        }
        else {
            System.out.println(0);
        }
        return 0;
    }
}
