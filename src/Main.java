import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    /**
      * TODO In the main method, create a seaport with at least five different types of container ships loaded with different containers.
      *  Additionally, several containers of different types should be placed in the warehouse
      **/

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);  //For user input
        int intInput;  //For Integer input
        String strInput;  //For String input
        boolean loopStop = true;  //Boolean for while loop

        MAINLOOP:   //Label
        while (loopStop) {
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
                case "1" -> {
                    //Create A Seaport
                    Seaport seaport = new Seaport();  //Creating new object of Seaport class
                    System.out.println("+-----------------------------------------+");
                    System.out.print("Name of the seaport: ");
                    seaport.name = scan.next();  //Setting the name of the seaport
                    while (true) {
                        seaport.menuForSeaport();  //Displaying the menu for seaport
                        System.out.print("> ");
                        intInput = scan.nextInt(); //Getting the input from user

                        switch (intInput) {
                            case 1 -> //Create Ships
                                    seaport.createShips(new Ships());  //Everytime creating new object

                            case 2 -> //Ships Info
                                    seaport.listInfo(); //Printing the elements of "ships" ArrayList

                            case 3 -> { //Back
                                continue MAINLOOP;  //goto label
                            }

                            case default ->
                                    System.out.println("Invalid Command, Please Try Again");
                        }
                    }
                }

                case "X" -> {
                    //Exit
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
        System.out.println("[X] Exit");
        System.out.println("+-----------------------------------------+");
    }
}
