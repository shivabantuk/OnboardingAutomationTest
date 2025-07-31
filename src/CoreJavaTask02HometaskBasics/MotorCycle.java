package CoreJavaTask02HometaskBasics;

public class MotorCycle implements Vehicles{
    int numberOfWheeels;
    String model;
    public MotorCycle(int numberOfWheeels, String model) {
        this.numberOfWheeels = 2;
        this.model = model;
    }

    @Override
    public void start() {
        System.out.println("Starting MotorCycle");

    }

    @Override
    public void stop() {
        System.out.println("Stopping MotorCycle");

    }

    @Override
    public void service() {

        System.out.println("Service Car");

    }

    public int getNumberOfWheeels() {
        return numberOfWheeels;
    }
}
