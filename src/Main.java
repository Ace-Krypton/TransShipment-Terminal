import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    /**
      * TODO In the main method, create a seaport with at least five different types of container ships loaded with different containers.
      *  Additionally, several containers of different types should be placed in the warehouse
     *       Demo for existing user entry
      *      for (Seaport seaPort : seaports) {  //Iterating through seaports list
      *                          while (true) {  //Always true
      *                              //If name is not null and name contained in ArrayList already it gives you message and input again
      *                              if (seaPort.getName() != null && seaPort.getName().contains(strInput)) {
      *                                  System.out.println("You already have \"" + seaPort.getName()
      *                                          + "\" account in system, Please try again");
      *                                  System.out.print("Name1 of the seaport: ");
      *                                  strInput = scan.next();
      *                              }
      *                              else break;
      *                          }
      *                      }
      **/

    public static void main(String[] args) {
        /*
         * This ArrayList takes the ships from seaport list
         * I created this because, when I went back to main menu, created ships were lost
         * That is the way I found to store them.
         **/
        ArrayList<Ships> ships = new ArrayList<>();
        ArrayList<Seaport> seaports = new ArrayList<>();
        Scanner scan = new Scanner(System.in);  //For user input
        String strInput;  //For String input
        boolean loopStop = true;  //Boolean for while loop

        MAINLOOP:   //Label
        while (loopStop) {  //Main loop
            menu(); //Calling static method menu for displaying the screen to the user
            System.out.print("> ");
            strInput = scan.next(); //Getting the input from user

            switch (strInput.toUpperCase(Locale.ROOT)) {
                case "1" -> { //Create A Seaport
                    System.out.println("+-----------------------------------------+");
                    Seaport seaport = new Seaport(); //Creating new object of Seaport class
                    seaports.add(seaport);  //Adding seaport object to the list
                    System.out.print("Name of the seaport: ");
                    strInput = scan.next(); //For user input
                    seaport.setName(strInput);  //Setting the name of the seaport

                    SEAPORTLOOP:
                    while (true) {  //Seaport Loop
                        seaport.menuForSeaport();  //Displaying the menu for seaport
                        System.out.print("> ");
                        strInput = scan.next(); //Getting the input from user

                        switch (strInput.toUpperCase(Locale.ROOT)) {
                            case "1" ->  //Create Ships
                                    seaport.createShips(new Ships());  //Everytime creating new object


                            case "2" -> { //Warehouse
                                 seaport.listInfo(); //Printing the elements of "ships" ArrayList
                                 ships.addAll(seaport.ships); //Appends all the elements to the specified collection
                            }

                            case "3" -> {  //Create Cargos
                                Cargo cargo = new Cargo();
                                CARGOLOOP:
                                while (true) {  //For Cargos
                                    cargo.cargoMenu();  //For Cargo Menu
                                    System.out.print("> ");
                                    strInput = scan.next(); //Getting the input from user

                                    switch (strInput.toUpperCase(Locale.ROOT)) {
                                        case "1" -> {  // Create Explosive Cargo
                                            
                                        }

                                        case "2" -> {  //Create Toxic Cargo
                                            //I am doing that
                                            while (true) {
                                                cargo.cargoToxicMenu();
                                                System.out.print("> ");
                                                strInput = scan.next(); //Getting the input from user

                                                switch (strInput.toUpperCase(Locale.ROOT)) {
                                                    case "1" -> //Toxic Liquid
                                                            System.out.println("Toxic liquid created!");

                                                    case "2" -> //Toxic Powdery
                                                            System.out.println("Toxic powdery created!");

                                                    case "A" -> {   //Back
                                                        continue CARGOLOOP;
                                                    }

                                                    case default ->
                                                            System.out.println("Invalid Command, Please Try Again");
                                                }
                                            }
                                        }

                                        case "3" -> {  //Create Liquid Cargo

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

                case "2" -> {  //Warehouse
                    for (Ships ship : ships) {  //Enhanced for loop for printing the elements of list
                        System.out.println(ship);
                    }
                }

                case "3" -> {  //Info About Existing Seaport
                    //User Input
                    System.out.print("Enter the name of the seaport: ");
                    strInput = scan.next();
                        //Iterating through our ArrayList
                        for (Seaport seaport : seaports) {
                            //If seaport name is not null and seaport name contains given string then do something
                            if (seaport.getName() != null && seaport.getName().contains(strInput))
                                System.out.println(seaport);
                            else {
                                System.out.println("+-----------------------------------------+");
                                System.out.println("There are not any seaports named " + strInput);
                            }
                        }
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
        System.out.println("[1] Create A Seaport");
        System.out.println("[2] Warehouse");
        System.out.println("[3] Info About Existing Seaport");
        System.out.println("[X] Exit");
        System.out.println("+-----------------------------------------+");
    }
}
