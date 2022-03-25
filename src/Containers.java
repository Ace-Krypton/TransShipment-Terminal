import java.util.ArrayList;
import java.util.Scanner;

public class Containers {
    /*
    * TODO
    *  • standard container,
    *  • heavy container, which is a type of standard container,
    *  • a refrigerated container, which is a type of heavy container, requiring connection to the
    *      ship’s electrical network,
    *  • a container for liquids cargo, which is a type of standard container,
    *  • a container for explosives cargo, which is a type of standard container,
    *  • a container for toxic cargo, which is a type of heavy container, which is available in two
    *      versions: a container for toxic powdery cargo and a container for toxic liquid cargo, which
    *      is not only a kind of heavy container, but also has the features of a container for liquids
    *      cargo.
    */

    ArrayList<ExplosiveContainer> explosiveContainers = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    String userInput;   //For user input
    double doubleInput; //For specific values

    //Method for creating new Explosive Container
    public void createExplosiveContainer(ExplosiveContainer explosiveContainer) {
        System.out.print("Name Of The Sender: ");
        userInput = scan.next();
        explosiveContainer.setSender(userInput);

        System.out.print("Tare: ");
        doubleInput = scan.nextDouble();
        explosiveContainer.setTare(doubleInput);

        System.out.print("Information About Security: ");
        userInput = scan.next();
        explosiveContainer.setInfoSecurity(userInput);

        System.out.print("Net Weight: ");
        doubleInput = scan.nextDouble();
        explosiveContainer.setNetWeight(doubleInput);

        System.out.print("Gross Weight: ");
        doubleInput = scan.nextDouble();
        explosiveContainer.setGrossWeight(doubleInput);

        System.out.print("Certificate Information: ");
        userInput = scan.next();
        explosiveContainer.setCertificateInfo(userInput);

        explosiveContainers.add(explosiveContainer);
    }

    //Explosive Container Info
    public void listInfo() {
        System.out.println("+-----------------------------------------+");
        //Checks if List is empty or not
        boolean isEmpty = explosiveContainers.isEmpty();
        if (isEmpty)
            System.out.println("You don't have any explosive containers right now");
        else{
            for (ExplosiveContainer containers : explosiveContainers) {
                System.out.println(containers);
            }
        }
    }

    public void containerInfo() {
        System.out.println("""
                      • standard container,
                      • heavy container, which is a type of standard container,
                      • a refrigerated container, which is a type of heavy container, requiring connection to the
                          ship’s electrical network,
                      • a container for liquids cargo, which is a type of standard container,
                      • a container for explosives cargo, which is a type of standard container,
                      • a container for toxic cargo, which is a type of heavy container, which is available in two
                          versions: a container for toxic powdery cargo and a container for toxic liquid cargo, which
                          is not only a kind of heavy container, but also has the features of a container for liquids
                          cargo.""");
    }

    public void containerCreateMenu() {
        System.out.println("+-----------------------------------------+");
        System.out.println("[1] Standard Container");
        System.out.println("[2] Heavy Container");
        System.out.println("[3] Refrigerated Container");
        System.out.println("[4] Liquid Container");
        System.out.println("[5] Explosive Container");
        System.out.println("[6] Toxic Container");
        System.out.println("[A] Back");
        System.out.println("[?] Info About Containers");
    }

    public void containerLoadMenu() {
        System.out.println("\n+-----------------------------------------+");
        System.out.println("[1] Load Cargo To Standard Container");
        System.out.println("[2] Load Cargo To Heavy Container");
        System.out.println("[3] Load Cargo To Liquid Container");
        System.out.println("[4] Load Cargo To Refrigerated Container");
        System.out.println("[5] Load Cargo To Explosive Container (This is the one working right now)");
        System.out.println("[6] Load Cargo To Toxic Container");
        System.out.println("[7] Load All Types To The One Container");
        System.out.println("[A] Back");
        System.out.println("\n+-----------------------------------------+");
    }
}
