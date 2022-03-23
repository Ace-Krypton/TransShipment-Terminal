import java.util.ArrayList;
import java.util.Scanner;

public class StandardContainer {
    //ArrayList for standard containers
    ArrayList<String> standardContainer = new ArrayList<>();
    //Scanner for user input
    Scanner scan = new Scanner(System.in);

    //This method is for loading container
    public void loadContainer(Cargo cargo) {
        System.out.println("\n+-----------------------------------------+");
        //For printing cargos
        cargo.printCargos();
        System.out.println("\n+-----------------------------------------+");

        while (true) {
            System.out.println("Which cargo you wanna add?");
            System.out.print("> ");
            String userInput = scan.next();

            for (ArrayList<String> cargosOne : cargo.cargos) {  //Iterating through cargos (All of them)
                for (String cargoAsList : cargosOne) {
                    //If user input equals cargo in the list (NO CASE SENSITIVE), and cargos contains user input
                    if (userInput.equalsIgnoreCase(cargoAsList) && cargoAsList.contains(userInput)) {
                        //Then adds that cargo to the list, the reason behind adding "cargoAsList" is that user input is not case-sensitive
                        standardContainer.add(userInput);
                        //After adding it removes such cargo in specified cargo list
                        cargosOne.remove(cargoAsList);
                    }
                }
            }

            System.out.println("You wanna add more? Press \"Y\" For Yes, \"N\" For No");
            System.out.print("> ");
            userInput = scan.next();

            //If user enters "n" or "N" it will break from the look
            if (userInput.equalsIgnoreCase("N")) break;
        }
    }
}
