package CollectionsTask9ExerciseNewPostStorageService;

public class Box {
    private final String sender;
    private final String receiver;
    private final double weight;
    private final double volume;
    private final double cost;
    private int office;

    public Box(String sender, String receiver, double weight, double volume, double cost, int i) {
        this.sender = sender;
        this.receiver = receiver;
        this.weight = weight;
        this.volume = volume;
        this.cost = cost;
        this.office = office;
    }
    public String getSender() {
        return sender;
    }
    public String getReceiver() {
        return receiver;
    }
    public double getWeight() {
        return weight;
    }
    public double getVolume() {
        return volume;
    }
    public double getCost() {
        return cost;
    }
    public int getOffice() {
        return office;
    }
    public void setOffice(int office) {
        this.office = office;
    }
}
