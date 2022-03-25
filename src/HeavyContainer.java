import java.util.ArrayList;

public class HeavyContainer extends StandardContainer {
    //ArrayList for heavy containers
    ArrayList<String> heavyContainer = new ArrayList<>();

    //For unique ID
    private int _id;
    int ID;

    //Info about container
    private String sender;
    private double tare;
    private String infoSecurity;
    private double netWeight;
    private double grossWeight;
    private String certificateInfo;

    public HeavyContainer() {
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

    @Override
    public String toString() {
        return "Sender: " + sender
                + "\nTare: " + tare
                + "\nInformation About Security: " + infoSecurity
                + "\nNet Weight: " + netWeight
                + "\nGross Weight: " + grossWeight
                + "\nCertificate Information: " + certificateInfo;
    }
}
