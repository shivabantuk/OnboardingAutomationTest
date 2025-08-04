package CollectionsTask10ExerciseShopcashboxes.CashBox;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop(4);
        System.out.println("Initial State");
        shop.print();
        System.out.println("Enable State");
        shop.setState(0,State.ENABLED);
        shop.setState(1,State.ENABLED);
        shop.print();
    }
}
