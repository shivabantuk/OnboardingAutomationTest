package CollectionsTask7Exercise1IteratingCollections;

public class Main {
    public static void main(String[] args) {
        Box.NewPostOffice npo = new Box.NewPostOffice();
        npo.addBox("shiva", "kumar", 1.0, 0.1, 1);
        for (Box b : Box.NewPostOffice.getListBox()) {
            System.out.println(b.sender + " " + b.recipient + " " + b.shippingCost);
        }


    }
}
