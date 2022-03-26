import java.util.ArrayList;

public class RefrigeratedContainer extends HeavyContainer{
    //ArrayList for refrigerated containers
    ArrayList<String> refrigeratedContainer = new ArrayList<>();

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
    boolean networkState = true;

    public RefrigeratedContainer() {
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
        System.out.println("""
                                                 !Warning!\040
                           You can only load Refrigerated Cargo to the Refrigerated Container
                           Also it must connect to the ship's electrical network
                           """);

        cargo.printCargos();
        System.out.println("\n+-----------------------------------------+");

        while (networkState) {
            System.out.println("Your container is not connected to the network");
            System.out.println("Type \"connect\" in order to connect the ship's network");
            System.out.print("> ");
            String connectNetwork = scan.next();

            if (connectNetwork.equalsIgnoreCase("connect")) {
                System.out.println("connected successfully");
                networkState = false;
            }
            else System.out.println("Please make sure you typed correctly");
        }

        while (true) {
            System.out.println("Which cargo you wanna add?");
            System.out.print("> ");
            String userInput = scan.next();

            for (ArrayList<String> cargosOne : cargo.cargos) {  //Iterating through cargos (All of them)
                for (String cargoAsList : cargosOne) {
                    //If user input equals cargo in the list (NO CASE SENSITIVE), and refrigerated cargos contains user input
                    if (userInput.equalsIgnoreCase(cargoAsList) && cargoAsList.contains(userInput)) {
                        //Then adds that cargo to the list, the reason behind adding "cargoAsList" is that user input is not case-sensitive
                        refrigeratedContainer.add(cargoAsList);
                    }
                }
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
                + "\nCertificate Information: " + certificateInfo;
    }
}
