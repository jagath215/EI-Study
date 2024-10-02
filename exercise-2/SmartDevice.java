public abstract class SmartDevice {
    protected int id;
    protected String status;

    public SmartDevice(int id) {
        this.id = id;
        this.status = "off";
    }

    public abstract void turnOn();
    public abstract void turnOff();
    
    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
