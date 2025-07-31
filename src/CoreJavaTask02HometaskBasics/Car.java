package CoreJavaTask02HometaskBasics;

public class Car implements Vehicles{
   private int numberOfWheeels;
  private   String model;
    public Car(int numberOfWheeels, String model) {
        this.numberOfWheeels = numberOfWheeels;
        this.model = model;
    }

    @Override
    public void start() {
        System.out.println("Starting Car " +  model );

    }

    @Override
    public void stop() {
        System.out.println("Stopping Car" + model);

    }

    @Override
    public void service() {
        System.out.println("Service Car" + model);

    }

    public int getNumberOfWheeels() {
        System.out.println("Number of wheels " + numberOfWheeels);
        return numberOfWheeels;
    }
}
