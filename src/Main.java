import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    /**
      * TODO In the main method, create a seaport with at least five different types of container ships loaded with different containers.
      *  Additionally, several containers of different types should be placed in the warehouse
      **/

    static Cargo cargo = new Cargo();
    static Containers container = new Containers();
    static Seaport seaport = new Seaport(); //Creating new object of Seaport class

    public static void main(String[] args) throws IOException {
        ArrayList<Seaport> seaports = new ArrayList<>();
        Hashtable<String, String> userPass = new Hashtable<>();
        Scanner scan = new Scanner(System.in);  //For user input
        String strInput;  //For String input
        boolean loopStop = true;  //Boolean for while loop

        MAINLOOP:   //Label
        while (loopStop) {  //Main loop
            menu(); //Calling static method menu for displaying the screen to the user
            System.out.print("> ");
            strInput = scan.next(); //Getting the input from user

            switch (strInput.toUpperCase(Locale.ROOT)) {
                case "1" -> { //Login Into Seaport Account
                    System.out.println("+-----------------------------------------+");
                    System.out.print("Please enter the username for seaport: ");
                    String username = scan.next();  //For username
                    System.out.print("Please enter the password for seaport: ");
                    String password = scan.next();  //For password

                    //If HashTable is not contains entered Key and Value it will give us "Authentication Revoked" and breaks
                    if (!userPass.containsKey(password) || !userPass.containsValue(username)) {
                        //https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
                        String ANSI_RED = "\u001B[31m";
                        String ANSI_RESET = "\u001B[0m";
                        System.out.println(ANSI_RED + "Authentication Revoked!" + ANSI_RESET);
                        break;  //Breaks from loop
                    }

                    System.out.print("Name of the seaport: ");
                    strInput = scan.next(); //For name of the seaport
                    seaport.setName(strInput);  //Setting the name of the seaport
                    seaports.add(seaport);  //Adding seaport object to the list

                    SEAPORTLOOP: //Label
                    while (true) {  //Seaport Loop
                        seaport.menuForSeaport();  //Displaying the menu for seaport
                        System.out.print("> ");
                        strInput = scan.next(); //Getting the input from user

                        switch (strInput.toUpperCase(Locale.ROOT)) {
                            case "1" ->  //Create Ships
                                    seaport.createShips(new Ships());  //Everytime creating new object

                            case "2" -> //Warehouse for ships
                                    seaport.listInfo(); //Printing the elements of "ships" ArrayList

                            case "3" -> {  //Create Cargos
                                CARGOLOOP:
                                while (true) {  //For Cargos
                                    cargo.cargoMenu();  //For Cargo Menu
                                    System.out.print("> ");
                                    strInput = scan.next(); //Getting the input from user

                                    switch (strInput.toUpperCase(Locale.ROOT)) {
                                        case "1" -> {  // Create Explosive Cargo
                                            System.out.print("Enter the name of the cargo (Explosive): ");
                                            strInput = scan.next(); //User Input
                                            cargo.explosiveCargos.add(strInput);
                                            System.out.println("Explosive Cargo Created!");
                                        }

                                        case "2" -> {  //Create Toxic Cargo
                                            while (true) {
                                                cargo.cargoToxicMenu();
                                                System.out.print("> ");
                                                strInput = scan.next(); //Getting the input from user

                                                switch (strInput.toUpperCase(Locale.ROOT)) {
                                                    case "1" -> {  //Toxic Liquid
                                                        System.out.print("Enter the name of the cargo (Toxic Liquid): ");
                                                        strInput = scan.next(); //User input
                                                        cargo.toxicLiquidCargos.add(strInput);
                                                        System.out.println("Toxic Liquid Cargo Created!");
                                                    }

                                                    case "2" -> {  //Toxic Powdery
                                                        System.out.print("Enter the name of the cargo (Toxic Powdery): ");
                                                        strInput = scan.next(); //User Input
                                                        cargo.toxicPowderyCargos.add(strInput);
                                                        System.out.println("Toxic powdery created!");
                                                    }

                                                    case "A" -> {   //Back
                                                        continue CARGOLOOP;
                                                    }

                                                    case default ->
                                                            System.out.println("Invalid Command, Please Try Again");
                                                }
                                            }
                                        }

                                        case "3" -> {  //Create Liquid Cargo
                                            System.out.print("Enter the name of the cargo (Liquid): ");
                                            strInput = scan.next();
                                            cargo.liquidCargos.add(strInput);
                                            System.out.println("Liquid Cargo Created!");
                                        }

                                        case "4" -> {  //Display Cargos
                                            //(I know there are code duplication here, but there is no way of doing that in other classes)
                                            cargo.displayCargosMenu();  //Menu for display cargos
                                            System.out.print("> ");
                                            strInput = scan.next(); //User Input
                                            boolean back = true;  //For stopping the loop

                                            while (back) {
                                                switch (strInput.toUpperCase(Locale.ROOT)) {
                                                    case "1" -> {   //Toxic Liquid
                                                        boolean isToxicLiquidEmpty = cargo.toxicLiquidCargos.isEmpty();
                                                        if (isToxicLiquidEmpty)
                                                            System.out.println("You don't have any toxic liquid cargo");
                                                        for (String toxicLiquid : cargo.toxicLiquidCargos)
                                                            System.out.println(toxicLiquid);
                                                        back = false;
                                                    }

                                                    case "2" -> {  //Toxic Powdery
                                                        boolean isToxicPowderyEmpty = cargo.toxicPowderyCargos.isEmpty();
                                                        if (isToxicPowderyEmpty)
                                                            System.out.println("You don't have any toxic powdery cargo");
                                                        for (String toxicPowdery : cargo.toxicPowderyCargos)
                                                            System.out.println(toxicPowdery);
                                                        back = false;
                                                    }

                                                    case "3" -> {  //Liquid
                                                        boolean isLiquidEmpty = cargo.liquidCargos.isEmpty();
                                                        if (isLiquidEmpty)
                                                            System.out.println("You don't have any liquid cargo");
                                                        for (String liquids : cargo.liquidCargos)
                                                            System.out.println(liquids);
                                                        back = false;
                                                    }

                                                    case "4" -> {  //Explosive
                                                        boolean isExplosiveEmpty = cargo.explosiveCargos.isEmpty();
                                                        if (isExplosiveEmpty)
                                                            System.out.println("You don't have any explosive cargo");
                                                        for (String explosiveAsList : cargo.explosiveCargos)
                                                            System.out.println(explosiveAsList);
                                                        back = false;
                                                    }

                                                    case "5" -> {  //All Cargos
                                                        boolean isCargosEmpty = cargo.cargos.isEmpty();
                                                        if (isCargosEmpty)
                                                            System.out.println("You have not confirmed cargos yet");
                                                        for (ArrayList<String> cargosAsList : cargo.cargos) {
                                                            for (String cargosOne : cargosAsList)
                                                                System.out.println(cargosOne);
                                                        }
                                                        back = false;
                                                    }

                                                    case "A" -> {  //Back
                                                        continue CARGOLOOP;
                                                    }

                                                    case default ->
                                                            System.out.println("Invalid Command, Please Try Again");
                                                }
                                            }
                                        }

                                        case "5" -> {   //Loading Cargo
                                            System.out.println("""
                                                                Do you want to confirm all of your cargos?
                                                                              Type "Yes" to confirm""");
                                            System.out.print("> ");
                                            strInput = scan.next(); //User input
                                            if (strInput.equalsIgnoreCase("Yes")) cargo.addCargos();
                                        }

                                        case "A" -> { //Back
                                            continue SEAPORTLOOP;
                                        }

                                        case default ->
                                                System.out.println("Invalid Command, Please Try Again");
                                    }
                                }
                            }

                            case "4" -> {  //Create Containers
                                while (true) {
                                    System.out.println("+-----------------------------------------+");
                                    System.out.println("These are the available containers that you can create");
                                    container.containerCreateMenu();  //Menu for container creating
                                    System.out.print("> ");
                                    strInput = scan.next(); //User input

                                    switch (strInput.toUpperCase(Locale.ROOT)) {
                                        case "1" -> {  //Standard Container
                                            container.createStandardContainer(new StandardContainer());
                                            System.out.println("Standard Container Created!");
                                        }

                                        case "2" -> {  //Heavy Container
                                            container.createHeavyContainer(new HeavyContainer());
                                            System.out.println("Heavy Container Created!");
                                        }

                                        case "3" -> {  //Refrigerated Container
                                            container.createRefrigeratedContainer(new RefrigeratedContainer());
                                            System.out.println("Refrigerated Container Created!");
                                        }

                                        case "4" -> {  //Liquid Container
                                            container.createLiquidContainer(new LiquidContainer());
                                            System.out.println("Liquid Container Created!");
                                        }

                                        case "5" -> {  //Explosive Container
                                            container.createExplosiveContainer(new ExplosiveContainer());
                                            System.out.println("Explosive Container Created!");
                                        }

                                        case "6" -> {  //Toxic Container
                                            container.createToxicContainer(new ToxicContainer());
                                            System.out.println("Toxic Container Created");
                                        }

                                        case "A" -> {  //Back
                                            continue SEAPORTLOOP;  //goto label
                                        }

                                        case "?" -> //Info About Containers
                                                container.containerInfo();

                                        case default ->
                                                System.out.println("Invalid Command, Please Try Again");
                                    }
                                }
                            }

                            case "5" -> {  //Warehouse For Containers
                                while (true) {
                                    container.warehouseMenu();  //Menu For WareHouse Of Containers
                                    System.out.print("> ");
                                    strInput = scan.next(); //User input

                                    switch (strInput.toUpperCase(Locale.ROOT)) {
                                        case "1" -> //Display Standard Containers
                                                Containers.standardInfo();

                                        case "2" -> //Display Heavy Containers
                                                Containers.heavyInfo();

                                        case "3" -> //Display Refrigerated Containers
                                                Containers.refrigeratedInfo();

                                        case "4" -> //Display Liquid Containers
                                                Containers.liquidInfo();

                                        case "5" -> //Display Explosive Containers
                                                Containers.explosiveInfo();

                                        case "6" -> //Display Toxic Containers
                                                Containers.toxicInfo();

                                        case "A" -> {  //Back
                                            continue SEAPORTLOOP;
                                        }

                                        case default ->
                                                System.out.println("Invalid Command, Please Try Again");
                                    }
                                }
                            }

                            case "6" -> {  //FileWriter
                                System.out.println("----------------------------------");
                                if (seaport.ships.isEmpty())  //Checks if it is empty or not
                                    System.out.println("Sorry you don't have any ships");
                                else {
                                    try {
                                        System.out.print("Please enter the path that you wanna save the file: ");
                                        strInput = scan.next(); //User input for path
                                        FileWriter writer = new FileWriter(strInput);  //Passing strInput as an argument
                                        System.out.println("----------------------------------");
                                        seaport.printInfo(writer);
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                            }

                            case "7" -> {  //Saving state (Reading from file)
                                // Creating an object of BufferedReader class
                                try {
                                    //Getting path from the user
                                    System.out.print("Enter the path: ");
                                    String path = scan.next();
                                    //BufferedReader for reading the file
                                    BufferedReader reader = new BufferedReader(new FileReader(path));
                                    //StringBuilder because everytime we are appending string value
                                    //For performance I used StringBuilder
                                    StringBuilder read = new StringBuilder();
                                    // Declaring a string variable
                                    String st;
                                    // Condition holds true till
                                    // there is character in a string
                                    while ((st = reader.readLine()) != null) read.append(st).append("\n");
                                    seaport.writeInfo(read);
                                } catch (FileNotFoundException e) {
                                    throw new RuntimeException(e);
                                }
                            }

                            case "A" -> { //Back
                                continue MAINLOOP;  //goto label
                            }

                            case default ->
                                    System.out.println("Invalid Command, Please Try Again");
                        }
                    }
                }

                case "2" -> {  //Info About Existing Seaport
                    //User Input
                    System.out.print("Enter the name of the seaport: ");
                    strInput = scan.next();
                        //Iterating through our ArrayList
                        for (Seaport seaportAsList : seaports) {
                            //If seaport name is not null and seaport name contains given string then do something
                            if (seaportAsList.getName().contains(strInput))
                                System.out.println(seaportAsList);
                            else {
                                System.out.println("+-----------------------------------------+");
                                System.out.println("There are not any seaports named " + strInput);
                            }
                        }
                }

                case "3" -> {  //Creating A Seaport Account
                    String username;  //Initializing variable
                    do {
                        System.out.print("Username: ");   //For Username
                        username = scan.next();
                    }
                    while (userPass.containsValue(username));  //While username already exist in hashtable get input again
                    System.out.print("Password: ");
                    String password = scan.next(); //For password
                    userPass.put(password, username); //Putting the key and value
                    System.out.println("Account Created Successfully!");
                }

                case "4" -> System.out.println("""
                                   * are important parts
                                                       ~ Login System ~
                                   First I want to start with login system that I wrote.
                                   Login system uses hash table for storing passwords and usernames,
                                   which are also known as keys and values, I used hash table because,
                                   I know that hash table uses functions also known as algorithms to calculate
                                   each index based on the key, which means we are saving time when we search from
                                   our list, instead of using linear searching. And I think HashTable in Java is dynamic
                                   that is why it is preventing possible collision.
                                   
                                   *You should create an account with pressing [3], and login to that account with [1] option
                                   
                                                       ~ After Login ~
                                   After logged in, you should put the name for your seaport. First thing you will see is
                                   gonna be 6 options. First let's start with creating cargos, cus you need cargos for your containers
                                   right? Probably not :) But I created it anyways. *So you have to press [3] in order to create
                                   cargo. When you press [3] you will see 5 options. *[1] will create Explosive cargos.
                                   *[2] will create Toxic cargo, but there is two options with toxic cargo, you can create
                                   toxic liquid or toxic powdery and they only goes to toxic container. *[3] will create liquid cargos.
                                   *After you done with creating don't do back or don't do anything before you confirm them,
                                   in order to confirm the cargos just press [5] and type "yes" to confirm. After that
                                   do whatever you want. You could display your cargos or just go back with [A]. *When you go back,
                                   you have to create container with pressing [4] and you will see bunch of options, just create
                                   a container you want and load it with cargos with typing the names of cargos, but remember
                                   you could only load toxic cargo to toxic container, and also in case of refrigerated container,
                                   you have to connect it to the ship's internal network, when you create it, just type "connect"
                                   in order to connect it to the ship's internal network. *You could also display this containers
                                   with pressing [5] which is warehouse for containers. Also containers and cargos have their own weights
                                   so you have to be careful to not overload your ship with containers. When you finished all of that
                                   you can do the last step, which is creating your ship. *Press [1] to create ship, enter the fields
                                   required by ship, then add container to it with typing the unique ID of container. *Finish your adding
                                   process with pressing [F] and it is all done now you can see your ship from warehouse for ships
                                   by pressing [2].
                                   
                                                       ~ File Output And Input ~
                                   I used FileWriter to write results to my file, actually user can enter the path for file.
                                   *Press [6] to give the path and write results to the file.""");

                case "5" ->
                        System.out.println("""
                                                          Ramiz Abbasov aka Krypton
                                           If you want to see progress I did with project check this out
                                              https://github.com/Ace-Krypton/TransShipment-Terminal""");

                case "X" -> {  //Exit
                    System.out.println("Exiting....");
                    loopStop = false;
                }

                case default ->
                        System.out.println("Invalid Command, Please Try Again");
            }
        }
    }

    //Menu for console
    public static void menu() {
        System.out.println("+-----------------------------------------+");
        System.out.println("[1] Login Into Seaport Account");
        System.out.println("[2] Info About Existing Seaport Account");
        System.out.println("[3] Create A Seaport Account");
        System.out.println("[4] Tutorial");
        System.out.println("[5] Credits\n");
        System.out.println("[X] Exit");
        System.out.println("+-----------------------------------------+");
    }
}
