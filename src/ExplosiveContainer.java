import java.util.ArrayList;
import java.util.Scanner;

public class ExplosiveContainer extends StandardContainer {
    //Scanner for user input
    Scanner scan = new Scanner(System.in);
    //ArrayList of explosive containers
    ArrayList<String> explosiveContainer = new ArrayList<>();

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

    public ExplosiveContainer() {
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
                        explosiveContainer.add(cargoAsList);
                    }
                }
            }

            //After adding it removes such cargo in specified cargo list
            for (String elements : explosiveContainer)
                cargo.explosiveCargos.remove(elements);

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
                + "\nCertificate Information: " + certificateInfo;
    }
}
