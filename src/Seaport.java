import java.util.ArrayList;
import java.util.Scanner;

public class Seaport {
    Scanner scan = new Scanner(System.in);  //Scanner for User input
    public ArrayList<Ships> ships = new ArrayList<>();  //ArrayList for ships
    public String name;   //Name of the seaport
    Ships ship = new Ships();  //Creating object of Ships class
    String userInput;   //For user input

    //Creating Ships
    public void createShips() {
        System.out.print("Name Of The Ship: ");
        userInput = scan.next();
        ship.setName(userInput); //Setting the name of the ship

        System.out.print("Transport Origin: ");
        userInput = scan.next();
        ship.setTransportOrigin(userInput); //Setting the transport origin of the ship

        System.out.print("Home Port: ");
        userInput = scan.next();
        ship.setHomePort(userInput);  //Setting the home port of the ship

        System.out.print("Destination: ");
        userInput = scan.next();
        ship.setDestination(userInput); //Setting the destination of the ship

        ships.add(ship);
        for (Ships shipList : ships) {
            System.out.println(shipList);
        }
    }

    //Ship Info
    public String shipInfo() {
        System.out.println("+-----------------------------------------+");
        return ship.toString();
    }

    //Menu For Seaport
    public void menuForSeaport() {
        System.out.println("\n+-----------------------------------------+");
        System.out.println("Name Of The Seaport: " + name);
        System.out.println("[1] Create Ships");
        System.out.println("[2] Ships Info");
        System.out.println("[3] Back");
        System.out.println("+-----------------------------------------+");
    }
}
