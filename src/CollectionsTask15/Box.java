package CollectionsTask15;

import java.util.Comparator;

public class Box implements Comparable<Box> {
    private final int id;
    private final String sender;
    private final String recipient;
    private final double weight;
    private final double volume;
    private final double cost;
    private final String city;
    private final String office;

    public Box(int id, String sender, String recipient, double weight, double volume, double cost, String city, String office) {
        this.id = id;
        this.sender = sender;
        this.recipient = recipient;
        this.weight = weight;
        this.volume = volume;
        this.cost = cost;
        this.city = city;
        this.office = office;
    }

    public int getId() {
        return id;
    }
    public String getSender() {
        return sender;
    }
    public String getRecipient() {
        return recipient;
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
    public String getCity() {
        return city;
    }
    public String getOffice() {
        return office;
    }

@Override
    public int compareTo(Box o) {
        return Integer.compare(this.id, o.id);
    }
    @Override
    public String toString() {
        return "parcel";

    }



}
