public class Ships {
    private static int _id; //No one could change unique ID from outside
    public int ID;  //For unique ID
    String name;  //Indicates the name of the ship
    private String homePort;  //For home port
    private String transportOrigin; //For transport origin
    private String destination; //For destination of the ship

    //Constructor
    public Ships(String name) {
        this.name = name;
        ++_id;
        ID = _id;
    }

    //Getters and setters
    public String getHomePort() {
        return homePort;
    }

    public void setHomePort(String homePort) {
        this.homePort = homePort;
    }

    public String getTransportOrigin() {
        return transportOrigin;
    }

    public void setTransportOrigin(String transportOrigin) {
        this.transportOrigin = transportOrigin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    //Overriding toString() method
    @Override
    public String toString() {
        return "(" + ID + ") " + name;  //returns unique ID and Name of the ship
    }
}
