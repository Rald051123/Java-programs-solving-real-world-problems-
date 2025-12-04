abstract class Device {
    private boolean isOn;// Encapsulated
    private String deviceName;

    public Device(String deviceName) {
        this.deviceName = deviceName;
        this.isOn = false;
    }

    // Encapsulated Getter
    public boolean isOn() {
        return isOn;
    }

    // Encapsulated Setter (turn on/off)
    public void turnOn() {
        this.isOn = true;
        System.out.println(deviceName + " is now ON.");
        showStatus();
    }

    public void turnOff() {
        this.isOn = false;
        System.out.println(deviceName + " is now OFF.");
        showStatus();
    }

    public String getDeviceName() {
        return deviceName;
    }

    // Abstract = forces the subclasses to implement unique behavior
    public abstract void showStatus();

    // Static method to turn ON or OFF a list of devices
    public static void powerControl(Device[] devices, boolean powerOn) {
        for (Device d : devices) {
            if (powerOn) d.turnOn();
            else d.turnOff();
        }
    }

    // Static method to count the devices ON
    public static int countDevicesOn(Device[] devices) {
        int count = 0;
        for (Device d : devices) {
            if (d.isOn()) count++;
        }
        return count;
    }
}

// Air Conditioner
class AirConditioner extends Device {
    private int fanSpeed;
    private double temperature;

    public AirConditioner() {
        super("Air Conditioner");
        this.fanSpeed = 3;
        this.temperature = 24;
    }

    public void setFanSpeed(int fanSpeed) {
        this.fanSpeed = fanSpeed;
        showStatus();
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        showStatus();
    }

    @Override
    public void showStatus() {
        if (isOn()) {
            System.out.println(getDeviceName() + " → Fan: " + fanSpeed + ", Temp: " + temperature + "°C");
        } else {
            System.out.println(getDeviceName() + " is OFF.");
        }
    }
}

// Lamp Shade
class LampShade extends Device {
    private int brightness;
    private String color;

    public LampShade(int brightness, String color) {
        super("Lamp Shade");
        this.brightness = brightness;
        this.color = color;
    }

    // Copy constructor
    public LampShade(LampShade ls) {
        super("Lamp Shade");
        this.brightness = ls.brightness;
        this.color = ls.color;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
        showStatus();
    }

    public void setColor(String color) {
        this.color = color;
        showStatus();
    }

    @Override
    public void showStatus() {
        if (isOn()) {
            System.out.println(getDeviceName() + " → Brightness: " + brightness + "%, Color: " + color);
        } else {
            System.out.println(getDeviceName() + " is OFF.");
        }
    }
}

// Television
class Television extends Device {
    private int channel;
    private int volume;

    public Television() {
        super("Television");
        this.channel = 1;
        this.volume = 10;
    }

    public void setChannel(int channel) {
        this.channel = channel;
        showStatus();
    }

    public void setVolume(int volume) {
        this.volume = volume;
        showStatus();
    }

    @Override
    public void showStatus() {
        if (isOn()) {
            System.out.println(getDeviceName() + " → Channel: " + channel + ", Volume: " + volume + "%");
        } else {
            System.out.println(getDeviceName() + " is OFF.");
        }
    }
}

// Microwave Oven
class Microwave extends Device {
    private int timer;
    private int temperature;

    public Microwave() {
        super("Microwave");
        this.timer = 0;
        this.temperature = 100;
    }

    public void setTimer(int timer) {
        this.timer = timer;
        showStatus();
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        showStatus();
    }

    @Override
    public void showStatus() {
        if (isOn()) {
            System.out.println(getDeviceName() + " → Timer: " + timer + "s, Temp: " + temperature + "°C");
        } else {
            System.out.println(getDeviceName() + " is OFF.");
        }
    }
}

// Main Program
public class SmartHomeSystem {
    public static void main(String[] args) {

        // Required Objects
        AirConditioner ac = new AirConditioner();

        LampShade lamp1 = new LampShade(100, "Yellow");
        LampShade lamp2 = new LampShade(lamp1);  // Copy constructor

        Television tv = new Television();

        Microwave mw = new Microwave();

        // Array of polymorphic references
        Device[] devices = { ac, lamp1, lamp2, tv, mw };

        // Turn everything ON
        System.out.println("\n--- Turning All ON ---");
        Device.powerControl(devices, true);

        // Turn everything OFF
        System.out.println("\n--- Turning All OFF ---");
        Device.powerControl(devices, false);

        // Count devices ON
        System.out.println("\nDevices currently ON: " + Device.countDevicesOn(devices));
    }
}
