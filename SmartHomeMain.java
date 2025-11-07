// Base Class(Father)
class Device {
    protected String deviceName;
    protected String status; // Only "ON" or "OFF"
    protected String location;
    protected static int deviceCount = 0;

    // Default constructor
    public Device() {
        this.deviceName = "Unknown Device";
        this.status = "OFF";
        this.location = "Unassigned";
        deviceCount++;
    }

    // Parameterized constructor
    public Device(String deviceName, String status, String location) {
        this.deviceName = deviceName;
        this.status = status;
        this.location = location;
        deviceCount++;
    }

    // Methods to make the status only accept on or off and also the displayinfo
    public void turnOn() {
        this.status = "ON";
        System.out.println(deviceName + " is now ON.");
    }

    public void turnOff() {
        this.status = "OFF";
        System.out.println(deviceName + " is now OFF.");
    }

    public void displayInfo() {
        System.out.println("Device Name: " + deviceName);
        System.out.println("Status: " + status);
        System.out.println("Location: " + location);
    }

    public static void showDeviceCount() {
        System.out.println("Total devices that created: " + deviceCount);
    }
}

// Subclass: LightBulb(son or daughter of device class)
class LightBulb extends Device {
    private int brightnessLevel; // 0-100
    private String color;

    // Constructor with all parameters
    public LightBulb(String deviceName, String status, String location, int brightnessLevel, String color) {
        super(deviceName, status, location);
        this.brightnessLevel = brightnessLevel;
        this.color = color;
    }

    // Constructor with only devicename and location
    public LightBulb(String deviceName, String location) {
        super(deviceName, "OFF", location);
        this.brightnessLevel = 50;
        this.color = "Warm White";
    }

    // Method to adjust brightness
    public void adjustBrightness(int level) {
        if (level < 0 || level > 100) {
            System.out.println("Brightness level must be between 0 and 100.");
        } else {
            this.brightnessLevel = level;
            System.out.println(deviceName + " brightness is set to " + brightnessLevel + "%.");
        }
    }

    // To Override the displayInfo
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Brightness Level: " + brightnessLevel + "%");
        System.out.println("Color: " + color);
        System.out.println("---------------------------");
    }
}

// Subclass: Thermostat(son or daughter of device class)
class Thermostat extends Device {
    private double temperature;
    private String mode; // "cooling" or "heating"

    // Constructor
    public Thermostat(String deviceName, String status, String location, double temperature, String mode) {
        super(deviceName, status, location);
        this.temperature = temperature;
        this.mode = mode;
    }

    // Overloaded setTemperature() methods
    public void setTemperature(double temp) {
        this.temperature = temp;
        System.out.println(deviceName + " temperature is set to " + temp + "°C.");
    }

    public void setTemperature(double temp, String mode) {
        this.temperature = temp;
        this.mode = mode;
        System.out.println(deviceName + " is set to " + mode + " mode at " + temp + "°C.");
    }

    // Override displayInfo
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Temperature: " + temperature + "°C");
        System.out.println("Mode: " + mode);
        System.out.println("---------------------------");
    }
}

// SmartHomeController Class
class SmartHomeController {
    private Device[] devices;

    public SmartHomeController(Device[] devices) {
        this.devices = devices;
    }

    public void turnAllOn() {
        System.out.println("\nTurning all devices ON...");
        for (Device d : devices) {
            d.turnOn();
        }
    }

    public void turnAllOff() {
        System.out.println("\nTurning all devices OFF...");
        for (Device d : devices) {
            d.turnOff();
        }
    }
}

// Main Class
public class SmartHomeMain {
    public static void main(String[] args) {
        // Create 1 instances of lightbulb and 2 instance of Thermostat
        LightBulb bulb = new LightBulb("Living Room Light","Living Room");
        Thermostat thermom1 = new Thermostat("Bedroom Thermostat", "ON", "Bedroom", 24.5, "cooling");
        Thermostat thermom2 = new Thermostat("Kitchen Thermostat", "OFF", "Kitchen", 22.0, "heating");

        //The Array of devices
        Device[] devices = {bulb, thermom1, thermom2};

        // Display all the device info
        System.out.println("=== Device Information ===");
        for (Device d : devices) {
            d.displayInfo();
        }

        // Show the total number of devices
        Device.showDeviceCount();

        // Creating the SmartHomeController
        SmartHomeController controller = new SmartHomeController(devices);

        // To Turn all the devices ON
        controller.turnAllOn();

        // To adjust the brightness and temperature of thermostat
        bulb.adjustBrightness(90);
        thermom1.setTemperature(25.5);
        thermom2.setTemperature(23.5, "cooling");

        // to turn off all of the devices
        controller.turnAllOff();

        System.out.println("\n=== Updated Device Information ===");
        for (Device d : devices) {
            d.displayInfo();
        }
    }
}
