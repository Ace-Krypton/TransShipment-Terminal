import java.util.ArrayList;
import java.util.Scanner;

public class StandardContainer {
    //ArrayList for standard containers
    static ArrayList<String> standardContainer = new ArrayList<>();

    //For storing elements that will remove soon
    ArrayList<String> removalList = new ArrayList<>();

    //Scanner for user input
    Scanner scan = new Scanner(System.in);

    //For unique ID
    private static int _id;
    int ID;

    //Info about container
    private String sender;
    private double tare;
    private String infoSecurity;
    private double netWeight;
    private double grossWeight;
    private String certificateInfo;
    public static double standardCapacityWithoutCargo = 100;
    public static double capacity = 0;

    public StandardContainer() {
        ++_id;
        ID = _id;
    }

    //Getters and Setters
    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setTare(double tare) {
        this.tare = tare;
    }

    public void setInfoSecurity(String infoSecurity) {
        this.infoSecurity = infoSecurity;
    }

    public void setNetWeight(double netWeight) {
        this.netWeight = netWeight;
    }

    public void setGrossWeight(double grossWeight) {
        this.grossWeight = grossWeight;
    }

    public void setCertificateInfo(String certificateInfo) {
        this.certificateInfo = certificateInfo;
    }

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
                        standardContainer.add(cargoAsList);
                        removalList.add(cargoAsList);
                        capacity += 50;
                    }
                }
            }

            //Same method that I used in Seaport class, storing used cargos in arraylist then removing them
            for (ArrayList<String> cargosOne : cargo.cargos) {
                cargosOne.removeAll(removalList);
            }

            System.out.println("You wanna add more? Press \"Y\" For Yes, \"N\" For No");
            System.out.print("> ");
            userInput = scan.next();

            //If user enters "n" or "N" it will break from the look
            if (userInput.equalsIgnoreCase("N")) break;
        }
    }

    @Override
    public String toString() {
        return ID + ". "
                + "Sender: " + sender
                + "\nTare: " + tare
                + "\nInformation About Security: " + infoSecurity
                + "\nNet Weight: " + netWeight
                + "\nGross Weight: " + grossWeight
                + "\nCertificate Information: " + certificateInfo
                + "\nCargos: " + standardContainer;
    }
}
