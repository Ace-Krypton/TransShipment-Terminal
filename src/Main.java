import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    /**
      * TODO In the main method, create a seaport with at least five different types of container ships loaded with different containers.
      *  Additionally, several containers of different types should be placed in the warehouse
      **/

    public static void main(String[] args) {
        /*
         * This ArrayList takes the ships from seaport list
         * I created this because, when I went back to main menu, created ships were lost
         * That is the way I found to store them.
         **/
        ArrayList<Seaport> seaports = new ArrayList<>();
        Seaport seaport = new Seaport(); //Creating new object of Seaport class
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
                        System.out.println("Authentication Revoked!");
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


                            case "2" -> //Warehouse
                                    seaport.listInfo(); //Printing the elements of "ships" ArrayList


                            case "3" -> {  //Create Cargos
                                Cargo cargo = new Cargo();
                                ExplosiveContainer explosive = new ExplosiveContainer();
                                Containers container = new Containers();
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
                                            cargo.cargos.addAll(cargo.explosiveCargos);
                                        }

                                        case "2" -> {  //Create Toxic Cargo
                                            while (true) {
                                                cargo.cargoToxicMenu();
                                                System.out.print("> ");
                                                strInput = scan.next(); //Getting the input from user

                                                switch (strInput.toUpperCase(Locale.ROOT)) {
                                                    case "1" -> { //Toxic Liquid
                                                        System.out.print("Enter the name of the cargo (Toxic Liquid): ");
                                                        strInput = scan.next(); //User input
                                                        cargo.toxicLiquidCargos.add(strInput);
                                                        System.out.println("Toxic Liquid Cargo Created!");
                                                        cargo.cargos.addAll(cargo.toxicLiquidCargos);
                                                    }

                                                    case "2" -> {  //Toxic Powdery
                                                        System.out.print("Enter the name of the cargo (Toxic Powdery): ");
                                                        strInput = scan.next(); //User Input
                                                        cargo.toxicPowderyCargos.add(strInput);
                                                        System.out.println("Toxic powdery created!");
                                                        cargo.cargos.addAll(cargo.toxicPowderyCargos);
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
                                            cargo.cargos.addAll(cargo.liquidCargos);
                                        }

                                        case "4" -> {  //Display Cargos
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
                                                        for (String liquid : cargo.liquidCargos)
                                                            System.out.println(liquid);
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

                                                    case "A" -> {  //Back
                                                        continue CARGOLOOP;
                                                    }

                                                    case default ->
                                                            System.out.println("Invalid Command, Please Try Again");
                                                }
                                            }
                                        }

                                        case "5" -> {   //Loading Cargo (Test)
                                            /*
                                             * System.out.println("If you want to see your explosive container press Y");
                                             *                                             System.out.print("> ");
                                             *                                             strInput = scan.next();
                                             *                                             if (strInput.equalsIgnoreCase("Y")) {
                                             *                                                 boolean isEmptyExplosive = explosive.explosiveContainer.isEmpty();
                                             *                                                 if (isEmptyExplosive)
                                             *                                                     System.out.println("You don't have any explosive containers right now");
                                             *                                                 else {
                                             *                                                     for (String explosiveAsList : explosive.explosiveContainer) {
                                             *                                                         System.out.println(explosiveAsList);
                                             *                                                     }
                                             *                                                 }
                                             *                                             }
                                             */
                                            container.containerMenu();
                                            while (true) {
                                                System.out.print("> ");
                                                strInput = scan.next(); //User input

                                                switch (strInput.toUpperCase(Locale.ROOT)) {
                                                    case "1" -> {  //Standard Container

                                                    }

                                                    case "2" -> {  //Heavy Container

                                                    }

                                                    case "3" -> { //Liquid Container

                                                    }

                                                    case "4" -> {  //Refrigerated Container

                                                    }

                                                    case "5" -> //Explosive Container
                                                            explosive.loadContainer(cargo);

                                                    case "6" -> {  //Toxic Container

                                                    }

                                                    case "A" -> {  //Back
                                                        continue CARGOLOOP;
                                                    }

                                                    case default ->
                                                            System.out.println("Invalid Command, Please Try Again");
                                                }
                                            }
                                        }

                                        case "A" -> { //Back
                                            continue SEAPORTLOOP;
                                        }

                                        case default ->
                                                System.out.println("Invalid Command, Please Try Again");
                                    }
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
                    System.out.print("Username: ");   //For Username
                    String username = scan.next();
                    System.out.print("Password: ");
                    String password = scan.next(); //For password
                    userPass.put(password, username); //Putting the key and value
                    System.out.println("Account Created Successfully!");
                }

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
        System.out.println("[X] Exit");
        System.out.println("+-----------------------------------------+");
    }
}
