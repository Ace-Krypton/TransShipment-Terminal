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
        System.out.print("Your cargos: ");
        int counter = 1;  //This is just for numbering

        //Checks if List is empty or not
        boolean isEmptyCargo = cargo.cargos.isEmpty();
        if (isEmptyCargo)
            System.out.println("You don't have any cargos right now");
        else {
            for (String cargosAsList : cargo.cargos) {  //Iterating through cargos (All of them)
                System.out.println(counter + ". " + cargosAsList);
                counter++;
            }
        }

        System.out.println("\n+-----------------------------------------+");
        System.out.println("Which cargo you wanna add?");
        System.out.print("> ");
        String userInput = scan.next();

        for (String cargoAsList : cargo.cargos) {   //Iterating through all cargos
            //If user input equals cargo in the list (NO CASE SENSITIVE), and explosive cargos contains user input
            if (userInput.equalsIgnoreCase(cargoAsList) && cargo.explosiveCargos.contains(userInput)) {
                //Then adds that cargo to the list, the reason behind adding "cargoAsList" is that user input is not case-sensitive
                explosiveContainer.add(cargoAsList);
            }
            else {
                System.out.println("You dumb ass look above");
                break;
            }
        }
    }
}
