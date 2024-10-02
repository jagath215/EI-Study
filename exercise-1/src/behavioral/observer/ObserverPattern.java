package src.behavioral.observer;
import java.util.ArrayList;
import java.util.List;

/*
 * Scenario: A weather station system where the WeatherStation notifies multiple display units (PhoneDisplay, WindowDisplay) when the temperature changes.
 */

// Observer interface
interface Observer {
    void update(float temperature);
}

// Subject class
class WeatherStation {
    private List<Observer> observers = new ArrayList<>();
    private float temperature;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}

// Concrete observers
class PhoneDisplay implements Observer {
    @Override
    public void update(float temperature) {
        System.out.println("Phone display shows: " + temperature + " degrees");
    }
}

class WindowDisplay implements Observer {
    @Override
    public void update(float temperature) {
        System.out.println("Window display shows: " + temperature + " degrees");
    }
}
