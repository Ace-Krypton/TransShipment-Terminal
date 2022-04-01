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

    //Adding different cargos to the one cargo
    public void addCargos() {
        cargos.add(explosiveCargos);
        cargos.add(toxicPowderyCargos);
        cargos.add(toxicLiquidCargos);
        cargos.add(liquidCargos);

//        Iterating through arraylist
//        for (ArrayList<String> elements : cargos) {
//            for (String element : elements) {
//                /*
//                 * https://www.geeksforgeeks.org/how-to-remove-duplicates-from-arraylist-in-java/
//                 * If cargos arraylist contains its elements it is not going to add it
//                 * Simply it does not add duplicate items
//                 */
//
//                if (!cargos.contains(elements) || !elements.contains(element))
//            }
//        }
    }

    public void printCargos() {
        System.out.print("Your cargos: \n");
        int counter = 1;

        //Checks if List is empty or not
        boolean isEmptyCargo = cargos.isEmpty();
        if (isEmptyCargo)
            System.out.println("You don't have any cargos right now");
        else {
            for (ArrayList<String> cargosAsList : cargos) {  //Iterating through cargos (All of them)
                for (String cargosOne : cargosAsList) {
                    System.out.println(counter + ". " + cargosOne);
                    counter++;
                }
            }
        }
    }

    //Menu for cargo
    public void cargoMenu() {
        System.out.println("\n+-----------------------------------------+");
        System.out.println("[1] Create Explosive Cargo");
        System.out.println("[2] Create Toxic Cargo");
        System.out.println("[3] Create Liquid Cargo");
        System.out.println("[4] Display Cargos");
        System.out.println("[5] Confirm cargos");
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
        System.out.println("[5] Display All Cargos");
        System.out.println("[A] Back");
        System.out.println("\n+-----------------------------------------+");
    }
}
