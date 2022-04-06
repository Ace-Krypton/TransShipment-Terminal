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

    static ArrayList<ExplosiveContainer> explosiveContainers = new ArrayList<>();
    static ArrayList<StandardContainer> standardContainers = new ArrayList<>();
    static ArrayList<HeavyContainer> heavyContainers = new ArrayList<>();
    static ArrayList<RefrigeratedContainer> refrigeratedContainers = new ArrayList<>();
    static ArrayList<LiquidContainer> liquidContainers = new ArrayList<>();
    static ArrayList<ToxicContainer> toxicContainers = new ArrayList<>();

    Scanner scan = new Scanner(System.in);
    String userInput;   //For user input
    double doubleInput; //For specific values
    static long startTime;
    static long endTime;

    //Method for creating new Standard Container
    public void createStandardContainer(StandardContainer standardContainer) {
        System.out.print("Name Of The Sender: ");
        userInput = scan.next();
        standardContainer.setSender(userInput);

        System.out.print("Tare: ");
        doubleInput = scan.nextDouble();
        standardContainer.setTare(doubleInput);

        System.out.print("Information About Security: ");
        userInput = scan.next();
        standardContainer.setInfoSecurity(userInput);

        System.out.print("Net Weight: ");
        doubleInput = scan.nextDouble();
        standardContainer.setNetWeight(doubleInput);

        System.out.print("Gross Weight: ");
        doubleInput = scan.nextDouble();
        standardContainer.setGrossWeight(doubleInput);

        System.out.print("Certificate Information: ");
        userInput = scan.next();
        standardContainer.setCertificateInfo(userInput);

        System.out.println("-------------loading container-------------");
        standardContainer.loadContainer(Main.cargo);

        standardContainers.add(standardContainer);

        startTime = System.currentTimeMillis();
    }

    //Standard Container Info
    public static void standardInfo() {
        System.out.println("+-----------------------------------------+");
        endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;
        if (timeElapsed >= 10000) {
            for (StandardContainer containers : standardContainers) {
                containers.setSender(null);
                containers.setCertificateInfo(null);
                containers.setGrossWeight(0);
                containers.setInfoSecurity(null);
                containers.setNetWeight(0);
                containers.setTare(0);
                StandardContainer.standardContainer.clear();
            }
        }

        //Checks if List is empty or not
        boolean isEmpty = standardContainers.isEmpty();
        if (isEmpty)
            System.out.println("You don't have any standard containers right now");
        else {
            for (StandardContainer containers : standardContainers) {
                System.out.println(containers);
            }
        }
    }

    //Method for creating new Heavy Container
    public void createHeavyContainer(HeavyContainer heavyContainer) {
        System.out.print("Name Of The Sender: ");
        userInput = scan.next();
        heavyContainer.setSender(userInput);

        System.out.print("Tare: ");
        doubleInput = scan.nextDouble();
        heavyContainer.setTare(doubleInput);

        System.out.print("Information About Security: ");
        userInput = scan.next();
        heavyContainer.setInfoSecurity(userInput);

        System.out.print("Net Weight: ");
        doubleInput = scan.nextDouble();
        heavyContainer.setNetWeight(doubleInput);

        System.out.print("Gross Weight: ");
        doubleInput = scan.nextDouble();
        heavyContainer.setGrossWeight(doubleInput);

        System.out.print("Certificate Information: ");
        userInput = scan.next();
        heavyContainer.setCertificateInfo(userInput);
        System.out.println("-------------loading container-------------");
        heavyContainer.loadContainer(Main.cargo);

        heavyContainers.add(heavyContainer);
    }

    //Heavy Container Info
    public static void heavyInfo() {
        System.out.println("+-----------------------------------------+");
        //Checks if List is empty or not
        boolean isEmpty = heavyContainers.isEmpty();
        if (isEmpty)
            System.out.println("You don't have any heavy containers right now");
        else{
            for (HeavyContainer containers : heavyContainers) {
                System.out.println(containers);
            }
        }
    }

    //Method for creating new Refrigerated Container
    public void createRefrigeratedContainer(RefrigeratedContainer refrigeratedContainer) {
        System.out.print("Name Of The Sender: ");
        userInput = scan.next();
        refrigeratedContainer.setSender(userInput);

        System.out.print("Tare: ");
        doubleInput = scan.nextDouble();
        refrigeratedContainer.setTare(doubleInput);

        System.out.print("Information About Security: ");
        userInput = scan.next();
        refrigeratedContainer.setInfoSecurity(userInput);

        System.out.print("Net Weight: ");
        doubleInput = scan.nextDouble();
        refrigeratedContainer.setNetWeight(doubleInput);

        System.out.print("Gross Weight: ");
        doubleInput = scan.nextDouble();
        refrigeratedContainer.setGrossWeight(doubleInput);

        System.out.print("Certificate Information: ");
        userInput = scan.next();
        refrigeratedContainer.setCertificateInfo(userInput);
        System.out.println("-------------loading container-------------");
        refrigeratedContainer.loadContainer(Main.cargo);

        refrigeratedContainers.add(refrigeratedContainer);
    }

    //Refrigerated Container Info
    public static void refrigeratedInfo() {
        System.out.println("+-----------------------------------------+");
        //Checks if List is empty or not
        boolean isEmpty = refrigeratedContainers.isEmpty();
        if (isEmpty)
            System.out.println("You don't have any refrigerated containers right now");
        else{
            for (RefrigeratedContainer containers : refrigeratedContainers) {
                System.out.println(containers);
            }
        }
    }

    //Method for creating new Liquid Container
    public void createLiquidContainer(LiquidContainer liquidContainer) {
        System.out.print("Name Of The Sender: ");
        userInput = scan.next();
        liquidContainer.setSender(userInput);

        System.out.print("Tare: ");
        doubleInput = scan.nextDouble();
        liquidContainer.setTare(doubleInput);

        System.out.print("Information About Security: ");
        userInput = scan.next();
        liquidContainer.setInfoSecurity(userInput);

        System.out.print("Net Weight: ");
        doubleInput = scan.nextDouble();
        liquidContainer.setNetWeight(doubleInput);

        System.out.print("Gross Weight: ");
        doubleInput = scan.nextDouble();
        liquidContainer.setGrossWeight(doubleInput);

        System.out.print("Certificate Information: ");
        userInput = scan.next();
        liquidContainer.setCertificateInfo(userInput);
        System.out.println("-------------loading container-------------");
        liquidContainer.loadContainer(Main.cargo);

        liquidContainers.add(liquidContainer);
    }

    //Liquid Container Info
    public static void liquidInfo() {
        System.out.println("+-----------------------------------------+");
        //Checks if List is empty or not
        boolean isEmpty = liquidContainers.isEmpty();
        if (isEmpty)
            System.out.println("You don't have any liquid containers right now");
        else{
            for (LiquidContainer containers : liquidContainers) {
                System.out.println(containers);
            }
        }
    }

    //Method for creating new Toxic Container
    public void createToxicContainer(ToxicContainer toxicContainer) {
        System.out.print("Name Of The Sender: ");
        userInput = scan.next();
        toxicContainer.setSender(userInput);

        System.out.print("Tare: ");
        doubleInput = scan.nextDouble();
        toxicContainer.setTare(doubleInput);

        System.out.print("Information About Security: ");
        userInput = scan.next();
        toxicContainer.setInfoSecurity(userInput);

        System.out.print("Net Weight: ");
        doubleInput = scan.nextDouble();
        toxicContainer.setNetWeight(doubleInput);

        System.out.print("Gross Weight: ");
        doubleInput = scan.nextDouble();
        toxicContainer.setGrossWeight(doubleInput);

        System.out.print("Certificate Information: ");
        userInput = scan.next();
        toxicContainer.setCertificateInfo(userInput);
        System.out.println("-------------loading container-------------");
        toxicContainer.loadContainer(Main.cargo);

        toxicContainers.add(toxicContainer);
    }

    //Toxic Container Info
    public static void toxicInfo() {
        System.out.println("+-----------------------------------------+");
        //Checks if List is empty or not
        boolean isEmpty = toxicContainers.isEmpty();
        if (isEmpty)
            System.out.println("You don't have any toxic containers right now");
        else{
            for (ToxicContainer containers : toxicContainers) {
                System.out.println(containers);
            }
        }
    }

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
        System.out.println("-------------loading container-------------");
        explosiveContainer.loadContainer(Main.cargo);

        explosiveContainers.add(explosiveContainer);
    }

    //Explosive Container Info
    public static void explosiveInfo() {
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
        System.out.println("[6] Toxic Container\n");
        System.out.println("[A] Back");
        System.out.println("[?] Info About Containers");
        System.out.println("+-----------------------------------------+");
    }

    public void warehouseMenu() {
        System.out.println("+-----------------------------------------+");
        System.out.println("[1] Display Standard Containers");
        System.out.println("[2] Display Heavy Containers");
        System.out.println("[3] Display Refrigerated Containers");
        System.out.println("[4] Display Liquid Containers");
        System.out.println("[5] Display Explosive Containers");
        System.out.println("[6] Display Toxic Containers\n");
        System.out.println("[A] Back");
        System.out.println("+-----------------------------------------+");
    }
}
