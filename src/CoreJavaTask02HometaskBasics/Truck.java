package CoreJavaTask02HometaskBasics;

public class Truck implements Vehicles{
    String model;
    int loadCapacity;

    public Truck(String model, int loadCapacity) {
        this.model = model;
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void start() {
        System.out.println("Starting Truck");

    }

    @Override
    public void stop() {

        System.out.println("Stopping Truck");

    }

    @Override
    public void service() {
        System.out.println("Service Truck");

    }

    public int getLoadCapacity() {
        System.out.println("Load Capacity " + loadCapacity);
        return loadCapacity;
    }
}
