import java.util.ArrayList;
import java.util.InputMismatchException;
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
        ArrayList<Ships> ships = new ArrayList<>();
        ArrayList<Seaport> seaports = new ArrayList<>();
        Scanner scan = new Scanner(System.in);  //For user input
        int intInput;  //For Integer input
        String strInput;  //For String input
        boolean loopStop = true;  //Boolean for while loop

        MAINLOOP:   //Label
        while (loopStop) {  //Main loop
            menu(); //Calling static method menu for displaying the screen to the user
            try {
                System.out.print("> ");
                strInput = scan.next(); //Getting the input from user
            } catch (InputMismatchException i) {
                System.out.println("Only Numbers From 1-3 Are Allowed");
                scan.nextLine();
                System.out.print("> ");
                strInput = scan.next(); //Getting the input from user
            }

            switch (strInput.toUpperCase(Locale.ROOT)) {
                case "1" -> { //Create A Seaport
                    System.out.println("+-----------------------------------------+");
                    Seaport seaport = new Seaport(); //Creating new object of Seaport class
                    seaports.add(seaport);
                    System.out.print("Name of the seaport: ");
                    seaport.setName(scan.next());  //Setting the name of the seaport
                    while (true) {
                        seaport.menuForSeaport();  //Displaying the menu for seaport
                        System.out.print("> ");
                        intInput = scan.nextInt(); //Getting the input from user

                        switch (intInput) {
                            case 1 ->  //Create Ships
                                    seaport.createShips(new Ships());  //Everytime creating new object


                            case 2 -> { //Warehouse
                                 seaport.listInfo(); //Printing the elements of "ships" ArrayList
                                 ships.addAll(seaport.ships); //Appends all the elements to the specified collection
                            }

                            case 3 -> { //Back
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

                case "3" -> {  //Go To The Existing Seaport
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
        System.out.println("[3] Go To The Existing Seaport");
        System.out.println("[X] Exit");
        System.out.println("+-----------------------------------------+");
    }
}
