package CollectionsTask9ExerciseNewPostStorageService;

public class Main {
    public static void main(String[] args) {
       NewPostOfficeStorage box = new NewPostOfficeStorageImpl();
       Box box1 = new Box("Anny", "Rajat", 2.5,4.0,100,1);
       box.acceptBox(box1);
       box.getBoxesWithWeightLessThan(3).forEach(b-> System.out.println(b.getSender() + " "+ b.getReceiver() ));

    }
}
