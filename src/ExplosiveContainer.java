import java.util.ArrayList;
import java.util.Scanner;

public class ExplosiveContainer extends StandardContainer {
    //Scanner for user input
    Scanner scan = new Scanner(System.in);
    //ArrayList of explosive containers
    ArrayList<String> explosiveContainer = new ArrayList<>();

    //This method is for loading container
    public void loadContainer(Cargo cargo) {
        System.out.println("\n+-----------------------------------------+");
        System.out.println("!Warning! You can only load explosive cargo to the explosive container");
        cargo.printCargos();
        System.out.println("\n+-----------------------------------------+");
        while (true) {
            System.out.println("Which cargo you wanna add?");
            System.out.print("> ");
            String userInput = scan.next();

            for (ArrayList<String> cargosOne : cargo.cargos) {  //Iterating through cargos (All of them)
                for (String cargoAsList : cargosOne) {
                    //If user input equals cargo in the list (NO CASE SENSITIVE), and explosive cargos contains user input
                    if (userInput.equalsIgnoreCase(cargoAsList) && cargo.explosiveCargos.contains(userInput)) {
                        //Then adds that cargo to the list, the reason behind adding "cargoAsList" is that user input is not case-sensitive
                        explosiveContainer.add(userInput);
                        //After adding it removes such cargo in specified cargo list
                        cargo.explosiveCargos.remove(userInput);
                    }
                }
            }

            System.out.println("You wanna add more? Press \"Y\" For Yes, \"N\" For No");
            System.out.print("> ");
            userInput = scan.next();

            if (userInput.equalsIgnoreCase("N")) break;
        }
    }
}
