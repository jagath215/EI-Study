public class DeviceProxy {
    private SmartDevice device;
    private boolean authorized;

    public DeviceProxy(SmartDevice device, boolean authorized) {
        this.device = device;
        this.authorized = authorized;
    }

    public void turnOn() {
        if (authorized) {
            device.turnOn();
        } else {
            System.out.println("Access denied. Unable to turn on device.");
        }
    }

    public void turnOff() {
        if (authorized) {
            device.turnOff();
        } else {
            System.out.println("Access denied. Unable to turn off device.");
        }
    }
}
