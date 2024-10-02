import java.util.Scanner;

public class SmartHomeApplication {
    public static void main(String[] args) {
        SmartHomeSystem homeSystem = new SmartHomeSystem();
        Scanner scanner = new Scanner(System.in);

        // Input the number of devices
        System.out.println("Enter the number of devices:");
        int deviceCount = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Input details for each device
        for (int i = 0; i < deviceCount; i++) {
            System.out.println(
                    "Enter device type (light/thermostat/doorlock), ID, and initial status (off/on for light and doorlock, temperature for thermostat):");
            String[] deviceDetails = scanner.nextLine().split(",");
            String type = deviceDetails[0].trim();
            int id = Integer.parseInt(deviceDetails[1].trim());
            int initialStatus = type.equals("thermostat") ? Integer.parseInt(deviceDetails[2].trim()) : 0;

            // Create the device using the factory method
            SmartDevice device = SmartDeviceFactory.createDevice(type, id, initialStatus);
            homeSystem.addDevice(device);
        }

        // Show the status of devices
        System.out.println("\nInitial Status of Devices:");
        homeSystem.showDeviceStatus();

        // Input the number of commands
        System.out.println("\nEnter the number of commands:");
        int commandCount = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Process each command
        for (int i = 0; i < commandCount; i++) {
            System.out.println("Enter command:");
            String command = scanner.nextLine().trim();

            if (command.startsWith("turnOn")) {
                int deviceId = Integer.parseInt(command.substring(command.indexOf("(") + 1, command.indexOf(")")));
                SmartDevice device = homeSystem.getDeviceById(deviceId);
                if (device != null) {
                    device.turnOn();
                } else {
                    System.out.println("Device not found.");
                }
            } else if (command.startsWith("turnOff")) {
                int deviceId = Integer.parseInt(command.substring(command.indexOf("(") + 1, command.indexOf(")")));
                SmartDevice device = homeSystem.getDeviceById(deviceId);
                if (device != null) {
                    device.turnOff();
                } else {
                    System.out.println("Device not found.");
                }
            } else if (command.startsWith("setSchedule")) {
                String[] parts = command.split("[(),\"]");
                int deviceId = Integer.parseInt(parts[1].trim());
                String time = parts[3].trim();
                String action = parts[5].trim();
                homeSystem.setSchedule(deviceId, time, action);
            } else if (command.startsWith("addTrigger")) {
                // Correctly split the command and retrieve values
                String[] parts = command.split("[(),\"]");

                // System.out.println("----------------------------------");

                // for (String part : parts) {
                // System.out.println(part);
                // }

                // System.out.println("----------------------------------");

                // Retrieve condition and operator
                String condition = parts[2].trim(); // "temperature"
                String operator = parts[5].trim(); // ">"

                // Retrieve threshold value (should be an integer)
                int threshold = Integer.parseInt(parts[7].trim()); // e.g., 75

                // Retrieve device ID for the action
                int deviceId = Integer.parseInt(parts[10].trim()); // turnOff(1)
                // int deviceId = 1;

                AutomationTrigger automationTrigger = new AutomationTrigger();
                SmartDevice thermostat = homeSystem.getDeviceById(2); // Assuming thermostat is device ID 2
                automationTrigger.addObserver(() -> {
                    if (thermostat instanceof Thermostat) {
                        if (operator.equals(">") && ((Thermostat) thermostat).getTemperature() > threshold) {
                            homeSystem.getDeviceById(deviceId).turnOff();
                        }
                    }
                });

                System.out.println("Automation trigger added: " + condition + " " + operator + " " + threshold
                        + " -> turnOff(" + deviceId + ")");
            }
        }

        // Show final status and scheduled tasks
        System.out.println("\nFinal Status of Devices:");
        homeSystem.showDeviceStatus();

        System.out.println("\nScheduled Tasks:");
        homeSystem.showSchedule();

        scanner.close();
    }
}
