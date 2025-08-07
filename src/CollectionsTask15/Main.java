package CollectionsTask15;

public class Main {
    public static void main(String[] args) {

        NewPostOfficeManagementImpl office = new NewPostOfficeManagementImpl();
        office.addBox("Alice", "Bob", 5.1,3.2,10.0,"London","Central");
        office.addBox("Charlie", "Dora", 2.2,1.1,5.0,"paris","west");
        System.out.println(office.getAssSortedBoxesByCost());
        System.out.println(office.getDescSortedBoxesWeight());
        System.out.println(office.getBoxById(1));
        System.out.println(office.getBoxesReceipient("Bob"));
    }
}
