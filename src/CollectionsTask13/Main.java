package CollectionsTask13;

public class Main {
    public static void main(String[] args) {
        HashtableOpen8to16<Integer, String> table = new  HashtableOpen8to16<>();
        table.insert(1, "apple");
        table.insert(2, "banana");
        table.insert(3, "cherry");
        table.insert(4, "pineapple");
        table.insert(5, "pineapple");

        System.out.println("Search key 3:  "+ table.get(3));

    }
}
