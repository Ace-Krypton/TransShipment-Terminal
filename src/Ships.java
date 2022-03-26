import java.util.ArrayList;

public class Ships implements IShips{
    private static int _id; //No one could change unique ID from outside
    public int ID;  //For unique ID
    private String name;  //Indicates the name of the ship
    private String homePort;  //For home port
    private String transportOrigin; //For transport origin
    private String destination; //For destination of the ship
    //public double capacity;  //Ship's capacity
    static ArrayList<ArrayList<StandardContainer>> standardContainer = new ArrayList<>();
    static ArrayList<ArrayList<HeavyContainer>> heavyContainer = new ArrayList<>();
    static String container;

    //Constructor
    public Ships() {
        ++_id;
        ID = _id;
    }

    /**
     * So what I did here is hard to understand maybe and so stupid,
     *    but that was the only way to make it, at least for me.
     * I created static printStandard() abstract method that takes userInput as an argument,
     *    then if userInput equals to standardContainer, it initializes standardContainer.toString() method,
     *    which is converting arraylist to string. And uses that variable in @Overrided toString() method.
     */
    public static void printStandard(String userInput) {
        if (userInput.equalsIgnoreCase("standardContainer")) {
            container = standardContainer.toString();
        }
    }

    public static void printHeavy(String userInput) {
        if (userInput.equalsIgnoreCase("heavyContainer")) {
            container = heavyContainer.toString();
        }
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
                  + "\n\tDestination: " + destination
                  + "\n\tContainer's Info: " + container;
    }
}
