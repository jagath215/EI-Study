public class Light extends SmartDevice {

    public Light(int id) {
        super(id);
    }

    @Override
    public void turnOn() {
        this.status = "on";
        System.out.println("Light " + id + " is turned on.");
    }

    @Override
    public void turnOff() {
        this.status = "off";
        System.out.println("Light " + id + " is turned off.");
    }
}
