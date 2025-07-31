package CoreJavaTask05_HometaskLanguageConstructs;

public class TrafficTicket {

    public static void main(String[] args) {
        speeding(85,true);


    }

    public static int speeding(int speed, boolean isBirthday){
        int allowance = isBirthday?5:0;
        if(speed<=60+allowance){
            System.out.println(0);
            return 0;
        }
        else if(speed<=80+allowance){
            System.out.println(1);

            return 1;

        }
        else
        {
            System.out.println(2);

            return 2;
        }

    }


}
