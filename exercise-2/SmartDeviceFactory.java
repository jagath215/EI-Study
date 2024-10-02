public class SmartDeviceFactory {

    public static SmartDevice createDevice(String type, int id, int initialTemperature) {
        switch (type.toLowerCase()) {
            case "light":
                return new Light(id);
            case "thermostat":
                return new Thermostat(id, initialTemperature);
            case "doorlock":
                return new DoorLock(id);
            default:
                throw new IllegalArgumentException("Unknown device type");
        }
    }
}
