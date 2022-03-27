import java.util.ArrayList;

public class Ships implements IShips{
    private static int _id; //No one could change unique ID from outside
    public int ID;  //For unique ID
    private String name;  //Indicates the name of the ship
    private String homePort;  //For home port
    private String transportOrigin; //For transport origin
    private String destination; //For destination of the ship
    //public double capacity;  //Ship's capacity

    //Static ArrayLists
    static ArrayList<ArrayList<StandardContainer>> standardContainer = new ArrayList<>();
    static ArrayList<ArrayList<HeavyContainer>> heavyContainer = new ArrayList<>();
    static ArrayList<ArrayList<ToxicContainer>> toxicContainer = new ArrayList<>();
    static ArrayList<ArrayList<RefrigeratedContainer>> refrigeratedContainer = new ArrayList<>();
    static ArrayList<ArrayList<LiquidContainer>> liquidContainer = new ArrayList<>();
    static ArrayList<ArrayList<ExplosiveContainer>> explosiveContainer = new ArrayList<>();


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

    //This method is printing containers inside of ship
    public void printShipContainers() {
        System.out.println("+-----------------------------------------+");
        System.out.println("Standard Containers: \n");

        for (ArrayList<StandardContainer> standard: standardContainer) {
            System.out.println(standard);
        }
    }

    //Overriding toString() method
    /** @returns unique ID and Name
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
                  + "\n\tDestination: " + destination;
    }
}
