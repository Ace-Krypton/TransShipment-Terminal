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
            System.out.println("[6] Toxic Container\n");
            System.out.println("[F] If You Finished With Adding Press \"F\"");

            System.out.print("> ");
            String userInput = scan.next();
            do {
                switch (userInput.toUpperCase(Locale.ROOT)) {
                    case "1" -> {  //Standard Container
                        System.out.println("+-----------------------------------------+");
                        System.out.println("These are your standard containers");
                        Containers.standardInfo();  //Printing standard containers
                        System.out.println("+-----------------------------------------+");
                        shipObjects.standardContainer.add(Containers.standardContainers); //Adding standard containers to the Ship
                        //Iterating through ArrayList of ArrayList and appending String contents to the builder
                        for (ArrayList<StandardContainer> standards : shipObjects.standardContainer)
                            for (StandardContainer standard : standards) shipObjects.builder.append("\n\t").append(standard);
                        Containers.standardContainers.clear();  //Removes all the elements from collection
                        Ships.capacity += 100;
                    }

                    case "2" -> {  //Heavy Container
                        System.out.println("+-----------------------------------------+");
                        System.out.println("These are your heavy containers");
                        Containers.heavyInfo();  //Printing heavy containers
                        System.out.println("+-----------------------------------------+");
                        shipObjects.heavyContainer.add(Containers.heavyContainers); //Adding heavy containers to the Ship
                        //Iterating through ArrayList of ArrayList and appending String contents to the builder
                        for (ArrayList<HeavyContainer> heavies : shipObjects.heavyContainer)
                            for (HeavyContainer heavy : heavies) shipObjects.builder.append("\n\t").append(heavy);
                        Containers.heavyContainers.clear(); //Removes all the elements from collection
                        Ships.capacity += 100;
                    }

                    case "3" -> {  //Refrigerated Container
                        System.out.println("+-----------------------------------------+");
                        System.out.println("These are your refrigerated containers");
                        Containers.refrigeratedInfo();  //Printing refrigerated containers
                        System.out.println("+-----------------------------------------+");
                        shipObjects.refrigeratedContainer.add(Containers.refrigeratedContainers); //Adding refrigerated containers to the Ship
                        //Iterating through ArrayList of ArrayList and appending String contents to the builder
                        for (ArrayList<RefrigeratedContainer> refrigerateds : shipObjects.refrigeratedContainer)
                            for (RefrigeratedContainer refrigerated : refrigerateds) shipObjects.builder.append("\n\t").append(refrigerated);
                        Containers.refrigeratedContainers.clear(); //Removes all the elements from collection
                        Ships.capacity += 100;
                    }

                    case "4" -> {  //Liquid Container
                        System.out.println("+-----------------------------------------+");
                        System.out.println("These are your liquid containers");
                        Containers.liquidInfo();  //Printing liquid containers
                        System.out.println("+-----------------------------------------+");
                        shipObjects.liquidContainer.add(Containers.liquidContainers); //Adding liquid containers to the Ship
                        //Iterating through ArrayList of ArrayList and appending String contents to the builder
                        for (ArrayList<LiquidContainer> liquids : shipObjects.liquidContainer)
                            for (LiquidContainer liquid : liquids) shipObjects.builder.append("\n\t").append(liquid);
                        Containers.liquidContainers.clear(); //Removes all the elements from collection
                        Ships.capacity += 100;
                    }

                    case "5" -> {  //Explosive Container
                        System.out.println("+-----------------------------------------+");
                        System.out.println("These are your explosive containers");
                        Containers.explosiveInfo();  //Printing explosive containers
                        System.out.println("+-----------------------------------------+");
                        shipObjects.explosiveContainer.add(Containers.explosiveContainers); //Adding explosive containers to the Ship
                        //Iterating through ArrayList of ArrayList and appending String contents to the builder
                        for (ArrayList<ExplosiveContainer> explosives : shipObjects.explosiveContainer)
                            for (ExplosiveContainer explosive : explosives) shipObjects.builder.append("\n\t").append(explosive);
                        Containers.explosiveContainers.clear(); //Removes all the elements from collection
                        Ships.capacity += 100;
                    }

                    case "6" -> {  //Toxic Container
                        System.out.println("+-----------------------------------------+");
                        System.out.println("These are your toxic containers");
                        Containers.toxicInfo();  //Printing toxic containers
                        System.out.println("+-----------------------------------------+");
                        shipObjects.toxicContainer.add(Containers.toxicContainers); //Adding toxic containers to the Ship
                        //Iterating through ArrayList of ArrayList and appending String contents to the builder
                        for (ArrayList<ToxicContainer> toxics : shipObjects.toxicContainer)
                            for (ToxicContainer toxic : toxics) shipObjects.builder.append("\n\t").append(toxic);
                        Containers.toxicContainers.clear(); //Removes all the elements from collection
                        Ships.capacity += 100;
                    }

                    case "F" -> loop = false;

                    case default ->
                            System.out.println("Invalid Command, Please Try Again");
                }
            } while (Ships.capacity >= 300);
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
        System.out.println("[5] Warehouse For Container\n");
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
