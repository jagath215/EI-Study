import java.util.ArrayList;
import java.util.List;

public class SmartHomeSystem {
    private List<SmartDevice> devices = new ArrayList<>();
    private Schedule schedule = new Schedule();

    // Method to add a device to the system
    public void addDevice(SmartDevice device) {
        devices.add(device);
    }

    // Method to retrieve a device by its ID
    public SmartDevice getDeviceById(int id) {
        for (SmartDevice device : devices) {
            if (device.getId() == id) {
                return device;
            }
        }
        return null; // Return null if device not found
    }

    // Method to display the status of all devices
    public void showDeviceStatus() {
        for (SmartDevice device : devices) {
            System.out.println("Device " + device.getId() + " is " + device.getStatus());
        }
    }

    // Method to set a schedule for a device
    public void setSchedule(int deviceId, String time, String action) {
        schedule.setSchedule(deviceId, time, action);
    }

    // Method to display the scheduled tasks
    public void showSchedule() {
        schedule.showSchedule();
    }
}
