import java.util.ArrayList;

public class Cargo {
    /*
     * TODO
     *      • Explosive Cargo
     *      • Toxic Cargo
     *      • Liquid Cargo
     *      • Toxic Powdery Cargo
     *      • Toxic Liquid Cargo
     */

    //Cargo Lists
    //ArrayList<ArrayList<String>> cargos = new ArrayList<>();
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
