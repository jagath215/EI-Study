public class Thermostat extends SmartDevice {
    private int temperature;

    public Thermostat(int id, int initialTemp) {
        super(id);
        this.temperature = initialTemp;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Thermostat " + id + " set to " + temperature + " degrees.");
    }

    @Override
    public void turnOn() {
        this.status = "on";
        System.out.println("Thermostat " + id + " is turned on.");
    }

    @Override
    public void turnOff() {
        this.status = "off";
        System.out.println("Thermostat " + id + " is turned off.");
    }
}
