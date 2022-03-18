public class Ships {
    private static int _id; //No one could change unique ID from outside
    public int ID;  //For unique ID
    private String name;  //Indicates the name of the ship
    private String homePort;  //For home port
    private String transportOrigin; //For transport origin
    private String destination; //For destination of the ship
    //public double capacity;  //Ship's capacity

    //Constructor
    public Ships() {
        ++_id;
        ID = _id;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setHomePort(String homePort) {
        this.homePort = homePort;
    }

    public void setTransportOrigin(String transportOrigin) {
        this.transportOrigin = transportOrigin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    //Overriding toString() method
    //@returns unique ID and Name, Transport Origin, Home Port and Destination of the ship
    @Override
    public String toString() {
        return ID + ". " + "Name: " + name + "\nTransport Origin: " + transportOrigin
              + "\nHome Port: " + homePort + "\nDestination: " + destination;
    }
}
