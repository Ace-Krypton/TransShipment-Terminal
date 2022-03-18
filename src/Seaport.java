import java.util.ArrayList;
import java.util.Scanner;

public class Seaport implements ISeaport {
    Scanner scan = new Scanner(System.in);  //Scanner for User input
    public ArrayList<Ships> ships = new ArrayList<>();  //ArrayList for ships
    public String name;   //Name of the seaport
    String userInput;   //For user input

    //Creating Ships
    public void createShips(Ships shipObjects) {
        System.out.print("Name Of The Ship: ");
        userInput = scan.next();
        shipObjects.setName(userInput); //Setting the name of the ship

        System.out.print("Transport Origin: ");
        userInput = scan.next();
        shipObjects.setTransportOrigin(userInput); //Setting the transport origin of the ship

        System.out.print("Home Port: ");
        userInput = scan.next();
        shipObjects.setHomePort(userInput);  //Setting the home port of the ship

        System.out.print("Destination: ");
        userInput = scan.next();
        shipObjects.setDestination(userInput); //Setting the destination of the ship

        ships.add(shipObjects);
    }

    //Ship Info
    public void listInfo() {
        System.out.println("+-----------------------------------------+");
        //Checks if List is empty or not
        boolean isEmpty = ships.isEmpty();
        if (isEmpty) System.out.println("You don't have any ships right now");
        else{
            for (Ships shipList : ships) {
                System.out.println(shipList);
            }
        }
    }

    //Menu For Seaport
    public void menuForSeaport() {
        System.out.println("\n+-----------------------------------------+");
        System.out.println("Name Of The Seaport: " + name);
        System.out.println("[1] Create Ships");
        System.out.println("[2] Warehouse");
        System.out.println("[3] Back");
        System.out.println("+-----------------------------------------+");
    }

    //Overriding toString() method
    /** @returns unique ID and Name
     * Transport Origin
     * Home Port
     * Destination of the ship
     **/
    @Override
    public String toString() {
        return "Name: " + name + "\nShips: " + ships;
    }
}
