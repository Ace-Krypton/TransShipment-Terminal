import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    /**
      * TODO In the main method, create a seaport with at least five different types of container ships loaded with different containers.
      *  Additionally, several containers of different types should be placed in the warehouse
      **/

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);  //For user input
        int intInput;  //For Integer input
        //String strInput;  //For String input
        boolean loopStop = true;  //Boolean for while loop

        while (loopStop) {
            menu(); //Calling static method menu for displaying the screen to the user
            try {
                System.out.print("> ");
                intInput = scan.nextInt(); //Getting the input from user
            } catch (InputMismatchException i) {
                System.out.println("Only Numbers From 1-3 Are Allowed");
                scan.nextLine();
                System.out.print("> ");
                intInput = scan.nextInt(); //Getting the input from user
            }

            switch (intInput) {
                case 1 -> {
                    Seaport seaport = new Seaport();  //Creating new object of Seaport class
                    System.out.println("+-----------------------------------------+");
                    System.out.print("Name of the seaport: ");
                    seaport.name = scan.next();  //Setting the name of the seaport
                    System.out.println("+-----------------------------------------+");

                }
                case 2 -> {
                    //Warehouse
                }

                case 3 -> {
                    System.out.println("Exiting....");
                    loopStop = false;
                }

                case default -> System.out.println("Invalid Command, Please Try Again");
            }
        }
//        Ships ship = new Ships("The Diamond Ark");
//        ship.setTransportOrigin("USA");
//        ship.setHomePort("Port of Virginia");
//        ship.setDestination("Port of Hong Kong");
//        System.out.println(ship);
    }

    //Menu for console
    public static void menu() {
        System.out.println("+-----------------------------------------+");
        System.out.println("[1] Create A Seaport");
        System.out.println("[2] Warehouse");
        System.out.println("[3] Exit");
        System.out.println("+-----------------------------------------+");
    }
}
