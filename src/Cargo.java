import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Cargo {
    /*
     * TODO
     *      • Explosive Cargo
     *      • Toxic Cargo
     *      • Liquid Cargo
     *      • Toxic Powdery Cargo
     *      • Toxic Liquid Cargo
     */

    Scanner scan = new Scanner(System.in);
    String strInput;

    //Cargo Lists
    ArrayList<ArrayList<String>> cargos = new ArrayList<>();
    ArrayList<String> explosiveCargos = new ArrayList<>();
    ArrayList<String> toxicPowderyCargos = new ArrayList<>();
    ArrayList<String> toxicLiquidCargos = new ArrayList<>();
    ArrayList<String> liquidCargos = new ArrayList<>();

    //Cargo Capacities
    /*
     *     final double cargoCapacityForToxic = 25;
     *     final double cargoCapacityForExplosive = 25;
     *     final double cargoCapacityForLiquid = 15;
     */

    //Create cargo for Toxic Liquid
    public void createCargoForToxicLiquid() {
        System.out.print("Enter the name of the cargo (Toxic Liquid): ");
        strInput = scan.next(); //User input
        toxicLiquidCargos.add(strInput);
    }

    //Create cargo for Toxic Powdery
    public void createCargoForToxicPowdery() {
        System.out.print("Enter the name of the cargo (Toxic Powdery): ");
        strInput = scan.next(); //User Input
        toxicPowderyCargos.add(strInput);
    }

    //Create cargo for Liquid
    public void createCargoForLiquid() {
        System.out.println("Enter the name of the cargo (Liquid): ");
        strInput = scan.next(); //User Input
        liquidCargos.add(strInput);
    }

    //Create cargo for Explosive
    public void createCargoForExplosive() {
        System.out.println("Enter the name of the cargo (Explosive): ");
        strInput = scan.next(); //User Input
        explosiveCargos.add(strInput);
    }

    //Menu for cargo
    public void cargoMenu() {
        System.out.println("\n+-----------------------------------------+");
        System.out.println("[1] Create Explosive Cargo");
        System.out.println("[2] Create Toxic Cargo");
        System.out.println("[3] Create Liquid Cargo");
        System.out.println("[4] Display Cargos");
        System.out.println("[A] Back");
        System.out.println("\n+-----------------------------------------+");
    }

    //Menu for cargo types
    public void cargoToxicMenu() {
        System.out.println("\n+-----------------------------------------+");
        System.out.println("[1] Create Toxic Liquid Cargo");
        System.out.println("[2] Create Toxic Powdery Cargo");
        System.out.println("[A] Back");
        System.out.println("\n+-----------------------------------------+");
    }

    //Display Cargos
    public void displayCargos() {
        System.out.print("> ");
        strInput = scan.next(); //User Input

        switch (strInput.toUpperCase(Locale.ROOT)) {
            case "1" -> {   //Toxic Liquid
                for (String toxicLiquid : toxicLiquidCargos) System.out.println(toxicLiquid);
            }

            case "2" -> {  //Toxic Powdery
                for (String toxicPowdery : toxicPowderyCargos) System.out.println(toxicPowdery);
            }

            case "3" -> {  //Liquid
                for (String liquid : liquidCargos) System.out.println(liquid);
            }

            case "4" -> {  //Explosive
                for (String explosive : explosiveCargos) System.out.println(explosive);
            }
        }
    }

    //Menu for displaying cargos
    public void displayCargosMenu() {
        System.out.println("\n+-----------------------------------------+");
        System.out.println("[1] Display Toxic Liquid Cargos");
        System.out.println("[2] Display Toxic Powdery Cargos");
        System.out.println("[3] Display Liquid Cargos");
        System.out.println("[4] Display Explosive Cargos");
        System.out.println("[A] Back");
        System.out.println("\n+-----------------------------------------+");
    }
}
