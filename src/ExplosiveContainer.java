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
        System.out.println("Welcome to the loading screen, You can only load explosive cargo to the explosive container");
        System.out.print("Your cargos: ");
        int counter = 1;  //This is just for numbering

        for (String cargosAsList : cargo.cargos) {
            System.out.println(counter + ". "+ cargosAsList);
            counter++;
        }

        System.out.println("\n+-----------------------------------------+");
        System.out.println("Which cargo you wanna add?");
        System.out.print("> ");
        String userInput = scan.next();

        for (String cargoAsList : cargo.cargos) {
            if (userInput.equalsIgnoreCase(cargoAsList)) {
                explosiveContainer.add(cargoAsList);
            }
        }

        for (String explosive : explosiveContainer) {
            System.out.println(explosive);
        }
    }
}
