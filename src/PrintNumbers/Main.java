package PrintNumbers;

public class Main{
    public static void main(String[] args) {

        PrintNumbers printNumbers = new PrintNumbers();
        Thread t = new Thread(printNumbers);
        t.start();
    }
}
