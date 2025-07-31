package CoreJavaTask02HometaskBasics;

public class MainSystem {
    public static void main(String[] args) {

        Vehicles car = new Car(4,"Audi");
        car.start();
        car.stop();
        car.start();
        Car car1 = new Car(4,"Audi");
        car1.getNumberOfWheeels();
        Truck Truck = new Truck("BenZ",5000);
        Truck.getLoadCapacity();


    }
}
