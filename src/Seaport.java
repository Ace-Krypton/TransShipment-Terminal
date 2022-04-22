import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Seaport {
    Scanner scan = new Scanner(System.in);  //Scanner for User input
    public ArrayList<Ships> ships = new ArrayList<>();  //ArrayList for ships
    private String name;   //Name of the seaport
    String userInput;   //For user input

    static ArrayList<String> list = new ArrayList<>();  //For output

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
            switch (userInput.toUpperCase(Locale.ROOT)) {
                case "1" -> {  //Standard Container
                    System.out.println("+-----------------------------------------+");
                    System.out.println("These are your standard containers");
                    Containers.standardInfo();  //Printing standard containers
                    //Adds all capacity to ship
                    shipObjects.capacity = StandardContainer.capacity + StandardContainer.standardCapacityWithoutCargo;
                    System.out.println("+-----------------------------------------+");
                    while (shipObjects.capacity >= 300) {  //If ship's capacity is equals or greater than 300 it will stop adding
                        System.out.println("""
                                   You have exceed the maximum capacity for Ship
                                               You must unload cargo""");
                        System.out.println("These are your containers:");
                        int count = 0;  //Just a number that comes before out cargos nothing special

                        //Prints all the cargos inside of container
                        for (String standard : StandardContainer.standardContainer) {
                            count++;
                            System.out.println(count + ". " + standard);
                        }

                        //User input
                        System.out.print("> ");
                        String inputUser = scan.next();

                        /*
                         * I experienced that you cannot remove elements from an arraylist
                         *     by just browsing it with "for each" loop it gives you ConcurrentModificationException.
                         * So I created a loop that finds the elements that has to be removed from our list
                         *     Then I am adding elements to that arraylist.
                         * After adding elements to my "removalList" I am removing them with using
                         *     list.removeAll(another Collection) command to remove them.
                         * BTW, I know you can do it with Iterator, but I don't know how to use it correctly yet :)
                         */

                        ArrayList<String> removalList = new ArrayList<>();
                        for (String standard : StandardContainer.standardContainer) {
                            if (inputUser.equalsIgnoreCase(standard) && StandardContainer.standardContainer.contains(inputUser)) {
                                removalList.add(standard);
                                StandardContainer.capacity -= 100;
                                shipObjects.capacity -= 100;
                            }
                        }
                        StandardContainer.standardContainer.removeAll(removalList);
                    }
                    ArrayList<StandardContainer> removalST = new ArrayList<>(); //ArrayList for elements that are supposed to removed
                    System.out.print("Which one you want to add (Please enter the ID) : ");
                    int addCon = scan.nextInt();
                    for (StandardContainer standard : Containers.standardContainers) {
                        if (shipObjects.standardContainer.contains(standard)) shipObjects.standardContainer.remove(standard);
                        else if (addCon == standard.ID) {
                            //If user entered ID found it adds that
                            shipObjects.standardContainer.add(standard);
                            //Adds element to the removal list
                            removalST.add(standard); //Removes the element from collection
                            shipObjects.builder.append("\n\t").append(standard); //Iterating through ArrayList and appending String contents to the builder
                        }
                    }
                    Containers.standardContainers.removeAll(removalST); //Removes all elements from removalList
                }

                case "2" -> {  //Heavy Container
                    System.out.println("+-----------------------------------------+");
                    System.out.println("These are your heavy containers");
                    Containers.heavyInfo();  //Printing heavy containers
                    System.out.println("+-----------------------------------------+");
                    shipObjects.capacity = HeavyContainer.capacity + HeavyContainer.heavyCapacityWithoutCargo;
                    while (shipObjects.capacity >= 300) {  //If ship's capacity is equals or greater than 300 it will stop adding
                        System.out.println("""
                                   You have exceed the maximum capacity for Ship
                                               You must unload cargo""");
                        System.out.println("These are your containers:");
                        int count = 0;  //Just a number that comes before out cargos nothing special

                        //Prints all the cargos inside of container
                        for (String heavy : HeavyContainer.heavyContainer) {
                            count++;
                            System.out.println(count + ". " + heavy);
                        }

                        //User input
                        System.out.print("> ");
                        String inputUser = scan.next();

                        /*
                         * I experienced that you cannot remove elements from an arraylist
                         *     by just browsing it with "for each" loop it gives you ConcurrentModificationException.
                         * So I created a loop that finds the elements that has to be removed from our list
                         *     Then I am adding elements to that arraylist.
                         * After adding elements to my "removalList" I am removing them with using
                         *     list.removeAll(another Collection) command to remove them.
                         * BTW, I know you can do it with Iterator, but I don't know how to use it correctly yet :)
                         */

                        ArrayList<String> removalList = new ArrayList<>();
                        for (String heavy : HeavyContainer.heavyContainer) {
                            if (inputUser.equalsIgnoreCase(heavy) && HeavyContainer.heavyContainer.contains(inputUser)) {
                                removalList.add(heavy);
                                HeavyContainer.capacity -= 100;
                                shipObjects.capacity -= 100;
                            }
                        }
                        HeavyContainer.heavyContainer.removeAll(removalList);
                    }
                    ArrayList<HeavyContainer> removalST = new ArrayList<>(); //ArrayList for elements that are supposed to removed
                    System.out.print("Which one you want to add (Please enter the ID) : ");
                    int addCon = scan.nextInt();
                    for (HeavyContainer heavy : Containers.heavyContainers) {
                        if (shipObjects.heavyContainer.contains(heavy)) shipObjects.heavyContainer.remove(heavy);
                        else if (addCon == heavy.ID) {
                            //If user entered ID found it adds that
                            shipObjects.heavyContainer.add(heavy);
                            //Adds element to the removal list
                            removalST.add(heavy); //Removes the element from collection
                            shipObjects.builder.append("\n\t").append(heavy); //Iterating through ArrayList and appending String contents to the builder
                        }
                    }
                    Containers.heavyContainers.removeAll(removalST); //Removes all elements from removalList
                }

                case "3" -> {  //Refrigerated Container
                    System.out.println("+-----------------------------------------+");
                    System.out.println("These are your refrigerated containers");
                    Containers.refrigeratedInfo();  //Printing refrigerated containers
                    System.out.println("+-----------------------------------------+");
                    shipObjects.capacity = RefrigeratedContainer.capacity + RefrigeratedContainer.refrigeratedCapacityWithoutCargo;
                    while (shipObjects.capacity >= 300) {  //If ship's capacity is equals or greater than 300 it will stop adding
                        System.out.println("""
                                   You have exceed the maximum capacity for Ship
                                               You must unload cargo""");
                        System.out.println("These are your containers:");
                        int count = 0;  //Just a number that comes before out cargos nothing special

                        //Prints all the cargos inside of container
                        for (String refrigerated : RefrigeratedContainer.refrigeratedContainer) {
                            count++;
                            System.out.println(count + ". " + refrigerated);
                        }

                        //User input
                        System.out.print("> ");
                        String inputUser = scan.next();

                        /*
                         * I experienced that you cannot remove elements from an arraylist
                         *     by just browsing it with "for each" loop it gives you ConcurrentModificationException.
                         * So I created a loop that finds the elements that has to be removed from our list
                         *     Then I am adding elements to that arraylist.
                         * After adding elements to my "removalList" I am removing them with using
                         *     list.removeAll(another Collection) command to remove them.
                         * BTW, I know you can do it with Iterator, but I don't know how to use it correctly yet :)
                         */

                        ArrayList<String> removalList = new ArrayList<>();
                        for (String refrigerated : RefrigeratedContainer.refrigeratedContainer) {
                            if (inputUser.equalsIgnoreCase(refrigerated) && RefrigeratedContainer.refrigeratedContainer.contains(inputUser)) {
                                removalList.add(refrigerated);
                                RefrigeratedContainer.capacity -= 100;
                                shipObjects.capacity -= 100;
                            }
                        }
                        RefrigeratedContainer.refrigeratedContainer.removeAll(removalList);
                    }
                    ArrayList<RefrigeratedContainer> removalST = new ArrayList<>(); //ArrayList for elements that are supposed to removed
                    System.out.print("Which one you want to add (Please enter the ID) : ");
                    int addCon = scan.nextInt();
                    for (RefrigeratedContainer refrigerated : Containers.refrigeratedContainers) {
                        if (shipObjects.refrigeratedContainer.contains(refrigerated)) shipObjects.refrigeratedContainer.remove(refrigerated);
                        else if (addCon == refrigerated.ID) {
                            //If user entered ID found it adds that
                            shipObjects.refrigeratedContainer.add(refrigerated);
                            //Adds element to the removal list
                            removalST.add(refrigerated); //Removes the element from collection
                            shipObjects.builder.append("\n\t").append(refrigerated); //Iterating through ArrayList and appending String contents to the builder
                        }
                    }
                    Containers.refrigeratedContainers.removeAll(removalST); //Removes all elements from removalList
                }

                case "4" -> {  //Liquid Container
                    System.out.println("+-----------------------------------------+");
                    System.out.println("These are your liquid containers");
                    Containers.liquidInfo();  //Printing liquid containers
                    System.out.println("+-----------------------------------------+");
                    shipObjects.capacity = LiquidContainer.capacity + LiquidContainer.liquidCapacityWithoutCargo;
                    while (shipObjects.capacity >= 300) {  //If ship's capacity is equals or greater than 300 it will stop adding
                        System.out.println("""
                                   You have exceed the maximum capacity for Ship
                                               You must unload cargo""");
                        System.out.println("These are your containers:");
                        int count = 0;  //Just a number that comes before out cargos nothing special

                        //Prints all the cargos inside of container
                        for (String liquid : LiquidContainer.liquidContainer) {
                            count++;
                            System.out.println(count + ". " + liquid);
                        }

                        //User input
                        System.out.print("> ");
                        String inputUser = scan.next();

                        /*
                         * I experienced that you cannot remove elements from an arraylist
                         *     by just browsing it with "for each" loop it gives you ConcurrentModificationException.
                         * So I created a loop that finds the elements that has to be removed from our list
                         *     Then I am adding elements to that arraylist.
                         * After adding elements to my "removalList" I am removing them with using
                         *     list.removeAll(another Collection) command to remove them.
                         * BTW, I know you can do it with Iterator, but I don't know how to use it correctly yet :)
                         */

                        ArrayList<String> removalList = new ArrayList<>();
                        for (String liquid : LiquidContainer.liquidContainer) {
                            if (inputUser.equalsIgnoreCase(liquid) && LiquidContainer.liquidContainer.contains(inputUser)) {
                                removalList.add(liquid);
                                LiquidContainer.capacity -= 100;
                                shipObjects.capacity -= 100;
                            }
                        }
                        LiquidContainer.liquidContainer.removeAll(removalList);
                    }
                    ArrayList<LiquidContainer> removalST = new ArrayList<>(); //ArrayList for elements that are supposed to removed
                    System.out.print("Which one you want to add (Please enter the ID) : ");
                    int addCon = scan.nextInt();
                    for (LiquidContainer liquid : Containers.liquidContainers) {
                        if (shipObjects.liquidContainer.contains(liquid)) shipObjects.liquidContainer.remove(liquid);
                        else if (addCon == liquid.ID) {
                            //If user entered ID found it adds that
                            shipObjects.liquidContainer.add(liquid);
                            //Adds element to the removal list
                            removalST.add(liquid); //Removes the element from collection
                            shipObjects.builder.append("\n\t").append(liquid); //Iterating through ArrayList and appending String contents to the builder
                        }
                    }
                    Containers.liquidContainers.removeAll(removalST); //Removes all elements from removalList
                }

                case "5" -> {  //Explosive Container
                    System.out.println("+-----------------------------------------+");
                    System.out.println("These are your explosive containers");
                    Containers.explosiveInfo();  //Printing explosive containers
                    System.out.println("+-----------------------------------------+");
                    shipObjects.capacity = ExplosiveContainer.capacity + ExplosiveContainer.explosiveCapacityWithoutCargo;
                    while (shipObjects.capacity >= 300) {  //If ship's capacity is equals or greater than 300 it will stop adding
                        System.out.println("""
                                   You have exceed the maximum capacity for Ship
                                               You must unload cargo""");
                        System.out.println("These are your containers:");
                        int count = 0;  //Just a number that comes before out cargos nothing special

                        //Prints all the cargos inside of container
                        for (String explosive : ExplosiveContainer.explosiveContainer) {
                            count++;
                            System.out.println(count + ". " + explosive);
                        }

                        //User input
                        System.out.print("> ");
                        String inputUser = scan.next();

                        /*
                         * I experienced that you cannot remove elements from an arraylist
                         *     by just browsing it with "for each" loop it gives you ConcurrentModificationException.
                         * So I created a loop that finds the elements that has to be removed from our list
                         *     Then I am adding elements to that arraylist.
                         * After adding elements to my "removalList" I am removing them with using
                         *     list.removeAll(another Collection) command to remove them.
                         * BTW, I know you can do it with Iterator, but I don't know how to use it correctly yet :)
                         */

                        ArrayList<String> removalList = new ArrayList<>();
                        for (String explosive : ExplosiveContainer.explosiveContainer) {
                            if (inputUser.equalsIgnoreCase(explosive) && ExplosiveContainer.explosiveContainer.contains(inputUser)) {
                                removalList.add(explosive);
                                ExplosiveContainer.capacity -= 100;
                                shipObjects.capacity -= 100;
                            }
                        }
                        ExplosiveContainer.explosiveContainer.removeAll(removalList);
                    }
                    ArrayList<ExplosiveContainer> removalST = new ArrayList<>(); //ArrayList for elements that are supposed to removed
                    System.out.print("Which one you want to add (Please enter the ID) : ");
                    int addCon = scan.nextInt();
                    for (ExplosiveContainer explosive : Containers.explosiveContainers) {
                        if (shipObjects.explosiveContainer.contains(explosive)) shipObjects.explosiveContainer.remove(explosive);
                        else if (addCon == explosive.ID) {
                            //If user entered ID found it adds that
                            shipObjects.explosiveContainer.add(explosive);
                            //Adds element to the removal list
                            removalST.add(explosive); //Removes the element from collection
                            shipObjects.builder.append("\n\t").append(explosive); //Iterating through ArrayList and appending String contents to the builder
                        }
                    }
                    Containers.explosiveContainers.removeAll(removalST); //Removes all elements from removalList
                }

                case "6" -> {  //Toxic Container
                    System.out.println("+-----------------------------------------+");
                    System.out.println("These are your toxic containers");
                    Containers.toxicInfo();  //Printing toxic containers
                    System.out.println("+-----------------------------------------+");
                    shipObjects.capacity = ToxicContainer.capacity + ToxicContainer.toxicCapacityWithoutCargo;
                    while (shipObjects.capacity >= 300) {  //If ship's capacity is equals or greater than 300 it will stop adding
                        System.out.println("""
                                   You have exceed the maximum capacity for Ship
                                               You must unload cargo""");
                        System.out.println("These are your containers:");
                        int count = 0;  //Just a number that comes before out cargos nothing special

                        //Prints all the cargos inside of container
                        for (String toxic : ToxicContainer.toxicPowderyContainer) {
                            count++;
                            System.out.println(count + ". " + toxic);
                        }

                        //User input
                        System.out.print("> ");
                        String inputUser = scan.next();

                        /*
                         * I experienced that you cannot remove elements from an arraylist
                         *     by just browsing it with "for each" loop it gives you ConcurrentModificationException.
                         * So I created a loop that finds the elements that has to be removed from our list
                         *     Then I am adding elements to that arraylist.
                         * After adding elements to my "removalList" I am removing them with using
                         *     list.removeAll(another Collection) command to remove them.
                         * BTW, I know you can do it with Iterator, but I don't know how to use it correctly yet :)
                         */

                        ArrayList<String> removalList = new ArrayList<>();
                        for (String toxic : ToxicContainer.toxicPowderyContainer) {
                            if (inputUser.equalsIgnoreCase(toxic) && ToxicContainer.toxicPowderyContainer.contains(inputUser)) {
                                removalList.add(toxic);
                                ToxicContainer.capacity -= 100;
                                shipObjects.capacity -= 100;
                            }
                        }
                        ToxicContainer.toxicPowderyContainer.removeAll(removalList);
                    }
                    ArrayList<ToxicContainer> removalST = new ArrayList<>(); //ArrayList for elements that are supposed to removed
                    System.out.print("Which one you want to add (Please enter the ID) : ");
                    int addCon = scan.nextInt();
                    for (ToxicContainer toxic : Containers.toxicContainers) {
                        if (shipObjects.toxicContainer.contains(toxic)) shipObjects.toxicContainer.remove(toxic);
                        else if (addCon == toxic.ID) {
                            //If user entered ID found it adds that
                            shipObjects.toxicContainer.add(toxic);
                            //Adds element to the removal list
                            removalST.add(toxic); //Removes the element from collection
                            shipObjects.builder.append("\n\t").append(toxic); //Iterating through ArrayList and appending String contents to the builder
                        }
                    }
                    Containers.toxicContainers.removeAll(removalST); //Removes all elements from removalList
                }

                case "F" -> loop = false;

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

    //Writer
    public void printInfo(FileWriter writer) throws IOException {
        System.out.println("+-----------------------------------------+");
        Collections.sort(list); //Sorts the list
        //Checks if List is empty or not
        boolean isEmpty = ships.isEmpty();  //Checks is empty or not
        if (isEmpty)
            System.out.println("You don't have any ships right now");
        else {
            for (Ships shipsAsList : ships) {
                list.add(String.valueOf(shipsAsList));  //Adds String values of elements of Ship ArrayList
            }
        }

        for (String l : list) { //Writing list to the file
            writer.write(l + "\n");
            System.out.println(l);
        }
        writer.close(); //Closing the stream
    }

    //Reader
    public void writeInfo(StringBuilder readData) {
        //We are initializing ship's values with null beforehand
        String name = null;
        String transportOrigin = null;
        String homePort = null;
        String destination = null;
        //String sender = null;
        //double tare = 0.0;
        //ArrayList<Object> containers = new ArrayList<>();
        //Converting readData which is StringBuilder to String with String.valueOf(readData)
        String data = String.valueOf(readData);
        //I used that to differentiate my ship's, that is why we need use split to count how many ship objects,
        //we have and give them indexes, maybe it is not a good idea, but I used it.
        String[] split = data.split("[+]-----------------------------------------[+]");

        //Using for loop, till we set all values to the ship objects
        for (int count = 0; count < split.length - 1; count++) {
            //I used pattern grouping to extract appropriate data
            //Name
            Pattern namePattern = Pattern.compile("(\\d).*(Name)..(\\w+)");
            Matcher nameMatcher = namePattern.matcher(split[count]);
            while (nameMatcher.find()) {
                name = nameMatcher.group(3);
            }

            //Transport origin
            Pattern transportPattern = Pattern.compile(".(Transport Origin)..(\\w+)");
            Matcher transportMatcher = transportPattern.matcher(split[count]);
            while (transportMatcher.find()) {
                transportOrigin = transportMatcher.group(2);
            }

            //Home port
            Pattern homePortPattern = Pattern.compile(".(Home Port)..(\\w+)");
            Matcher homePortMatcher = homePortPattern.matcher(split[count]);
            while (homePortMatcher.find()) {
                homePort = homePortMatcher.group(2);
            }

            //Destination
            Pattern destinationPattern = Pattern.compile(".(Destination)..(\\w+)");
            Matcher destinationMatcher = destinationPattern.matcher(split[count]);
            while (destinationMatcher.find()) {
                destination = destinationMatcher.group(2);
            }

            //Creating ship objects each time and setting values to them
            Ships ship = new Ships();
            ship.setName(name);
            ship.setTransportOrigin(transportOrigin);
            ship.setHomePort(homePort);
            ship.setDestination(destination);
            System.out.println(ship);

            //Checks if it has container or not
            //for (String splits : split) {
                //if (splits.contains("Sender")) {
                    //Sender
                    //Pattern senderPattern = Pattern.compile(".(\\d).*(Sender)..(\\w+)");
                    //Matcher senderMatcher = senderPattern.matcher(split[count]);
                    //while (senderMatcher.find()) {
                        //sender = senderMatcher.group(3);
                    //}
                    //containers.add(sender);

                    //Sender
                    //Pattern tarePattern = Pattern.compile("(Tare)..(\\w+.*)");
                    //Matcher tareMatcher = tarePattern.matcher(split[count]);
                    //while (tareMatcher.find()) {
                        //tare = Double.parseDouble(tareMatcher.group(2));
                    //}
                    //containers.add(tare);
                    //ship.savedContainers.add(containers);
                //}
            //}
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
        System.out.println("[6] Write To File");
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
