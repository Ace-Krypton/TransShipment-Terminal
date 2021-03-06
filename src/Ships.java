import java.util.ArrayList;

public class Ships {
    private static int _id; //No one could change unique ID from outside
    public int ID;  //For unique ID
    private String name;  //Indicates the name of the ship
    private String homePort;  //For home port
    private String transportOrigin; //For transport origin
    private String destination; //For destination of the ship
    public double capacity = 0;  //Ship's capacity
    ArrayList<StandardContainer> standardContainer = new ArrayList<>();
    ArrayList<HeavyContainer> heavyContainer = new ArrayList<>();
    ArrayList<ToxicContainer> toxicContainer = new ArrayList<>();
    ArrayList<RefrigeratedContainer> refrigeratedContainer = new ArrayList<>();
    ArrayList<LiquidContainer> liquidContainer = new ArrayList<>();
    ArrayList<ExplosiveContainer> explosiveContainer = new ArrayList<>();
    StringBuilder builder = new StringBuilder();

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

    /**
     * @returns unique ID and Name
     * Transport Origin
     * Home Port
     * Destination of the ship
     **/
    @Override
    public String toString() {
        return ID + ". "
                + " Name: " + name
                + "\n\tTransport Origin: " + transportOrigin
                + "\n\tHome Port: " + homePort
                + "\n\tDestination: " + destination
                + "\n\t" + builder + "\n" + "+-----------------------------------------+";
    }
}
