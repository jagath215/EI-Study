import java.util.HashMap;
import java.util.Map;

public class Schedule {
    private Map<Integer, String> schedule = new HashMap<>();

    public void setSchedule(int deviceId, String time, String action) {
        schedule.put(deviceId, time + " - " + action);
    }

    public void showSchedule() {
        for (Map.Entry<Integer, String> entry : schedule.entrySet()) {
            System.out.println("Device " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
