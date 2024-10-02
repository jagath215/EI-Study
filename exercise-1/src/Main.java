package src;
import behavioral.observer.ObserverPattern.java;
import behavioral.command.*;
import creational.singleton.*;
import creational.factory.*;
import structural.adapter.*;
import structural.composite.*;


public class Main {
    public static void main(String[] args) {
        // Observer pattern example
        WeatherStation weatherStation = new WeatherStation();
        PhoneDisplay phoneDisplay = new PhoneDisplay();
        WindowDisplay windowDisplay = new WindowDisplay();
        weatherStation.addObserver(phoneDisplay);
        weatherStation.addObserver(windowDisplay);
        weatherStation.setTemperature(25.5f);

        // Command pattern example
        Light light = new Light();
        RemoteControl remote = new RemoteControl();
        remote.setCommand(new LightOnCommand(light));
        remote.pressButton();
        remote.setCommand(new LightOffCommand(light));
        remote.pressButton();

        // Singleton pattern example
        Database db = Database.getInstance();
        db.connect();

        // Factory pattern example
        Vehicle car = VehicleFactory.createVehicle("car");
        car.drive();

        // Adapter pattern example
        RoundHole hole = new RoundHole(5);
        SquarePeg squarePeg = new SquarePeg(7);
        SquarePegAdapter adapter = new SquarePegAdapter(squarePeg);
        System.out.println(hole.fits(adapter));  // Should return false

        // Composite pattern example
        Directory root = new Directory("root");
        File file1 = new File("file1.txt");
        Directory subDir = new Directory("subDir");
        File file2 = new File("file2.txt");
        root.addComponent(file1);
        root.addComponent(subDir);
        subDir.addComponent(file2);
        root.showDetails();
    }
}