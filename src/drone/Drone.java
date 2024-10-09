package drone;

public class Drone {
    private String droneID;
    private String name;
    private double maxSpeed;
    private double weightCapacity;
    private double distanceAutonomy;
    private String fleetID;
    private double timeAutonomy;

    public Drone(String droneID, String name, double maxSpeed, double weightCapacity, double distanceAutonomy, String fleetID, double timeAutonomy) {
        this.droneID = droneID;
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.weightCapacity = weightCapacity;
        this.distanceAutonomy = distanceAutonomy;
        this.fleetID = fleetID;
        this.timeAutonomy = timeAutonomy;
    }

    // Getters and Setters
    public String getDroneID() { return droneID; }
    public void setDroneID(String droneID) { this.droneID = droneID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getMaxSpeed() { return maxSpeed; }
    public void setMaxSpeed(double maxSpeed) { this.maxSpeed = maxSpeed; }

    public double getWeightCapacity() { return weightCapacity; }
    public void setWeightCapacity(double weightCapacity) { this.weightCapacity = weightCapacity; }

    public double getDistanceAutonomy() { return distanceAutonomy; }
    public void setDistanceAutonomy(double distanceAutonomy) { this.distanceAutonomy = distanceAutonomy; }

    public String getFleetID() { return fleetID; }
    public void setFleetID(String fleetID) { this.fleetID = fleetID; }

    public double getTimeAutonomy() { return timeAutonomy; }
    public void setTimeAutonomy(double timeAutonomy) { this.timeAutonomy = timeAutonomy; }
}
