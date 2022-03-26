import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Seaport implements ISeaport {
    Scanner scan = new Scanner(System.in);  //Scanner for User input
    public ArrayList<Ships> ships = new ArrayList<>();  //ArrayList for ships
    private String name;   //Name of the seaport
    String userInput;   //For user input

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

        boolean loop = true;

        while (loop) {
            System.out.println("+-----------------------------------------+");
            System.out.println("Which container you wanna add to this ship?");
            System.out.println("Containers: ");
            System.out.println("[1] Standard Container");
            System.out.println("[2] Heavy Container");
            System.out.println("[3] Refrigerated Container");
            System.out.println("[4] Liquid Container");
            System.out.println("[5] Explosive Container");
            System.out.println("[6] Toxic Container");
            System.out.println("[F] If you finished adding press \"F\"");

            System.out.print("> ");
            String userInput = scan.next();

            switch (userInput.toUpperCase(Locale.ROOT)) {
                case "1" -> {  //Standard Container

                }

                case "2" -> {  //Heavy Container

                }

                case "3" -> {  //Refrigerated Container

                }

                case "4" -> {  //Liquid Container

                }

                case "5" -> {  //Explosive Container

                }

                case "6" -> {  //Toxic Container

                }

                case "A" -> loop = false;

                case default ->
                        System.out.println("Invalid Command, Please Try Again");
            }
        }
        ships.add(shipObjects);
    }

    //Ship Info
    public void listInfo() {
        System.out.println("+-----------------------------------------+");
        //Checks if List is empty or not
        boolean isEmpty = ships.isEmpty();
        if (isEmpty)
            System.out.println("You don't have any ships right now");
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
        System.out.println("[2] Warehouse For Ships");
        System.out.println("[3] Create Cargo");
        System.out.println("[4] Create Container");
        System.out.println("[5] Warehouse For Container");
        System.out.println("[A] Back");
        System.out.println("+-----------------------------------------+");
    }

    /** Overriding toString() method
     * @returns name and ships ArrayList
     **/
    @Override
    public String toString() {
        return " Name: " + name + "\n\tShips: " + ships;
    }
}
