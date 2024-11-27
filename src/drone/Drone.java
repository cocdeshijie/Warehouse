package drone;

public class Drone {
    private String droneID;
    private String fleetID;
    private String name;
    private double maxSpeed;
    private double weightCapacity;
    private double distanceAutonomy;
    private int timeAutonomy;
    private String assetID;

    public Drone(String droneID, String fleetID, String name, double maxSpeed,
                double weightCapacity, double distanceAutonomy, int timeAutonomy, String assetID) {
        this.droneID = droneID;
        this.fleetID = fleetID;
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.weightCapacity = weightCapacity;
        this.distanceAutonomy = distanceAutonomy;
        this.timeAutonomy = timeAutonomy;
        this.assetID = assetID;
    }

    // Getters and Setters
    public String getDroneID() { return droneID; }
    public void setDroneID(String droneID) { this.droneID = droneID; }

    public String getFleetID() { return fleetID; }
    public void setFleetID(String fleetID) { this.fleetID = fleetID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getMaxSpeed() { return maxSpeed; }
    public void setMaxSpeed(double maxSpeed) { this.maxSpeed = maxSpeed; }

    public double getWeightCapacity() { return weightCapacity; }
    public void setWeightCapacity(double weightCapacity) { this.weightCapacity = weightCapacity; }

    public double getDistanceAutonomy() { return distanceAutonomy; }
    public void setDistanceAutonomy(double distanceAutonomy) { this.distanceAutonomy = distanceAutonomy; }

    public int getTimeAutonomy() { return timeAutonomy; }
    public void setTimeAutonomy(int timeAutonomy) { this.timeAutonomy = timeAutonomy; }

    public String getAssetID() { return assetID; }
    public void setAssetID(String assetID) { this.assetID = assetID; }
}