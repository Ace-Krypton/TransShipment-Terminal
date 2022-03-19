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

    ArrayList<Cargo> cargos = new ArrayList<>();
    ArrayList<String> explosiveCargos = new ArrayList<>();
    ArrayList<String> toxicCargos = new ArrayList<>();
    ArrayList<String> liquidCargos = new ArrayList<>();

    //Create different types of cargos
    public void createCargo() {

    }

    //Menu for cargo
    public void cargoMenu() {
        System.out.println("\n+-----------------------------------------+");
        System.out.println("[1] Create Explosive Cargo");
        System.out.println("[2] Create Toxic Cargo");
        System.out.println("[3] Create Liquid Cargo");
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
}
