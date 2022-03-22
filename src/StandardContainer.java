import java.util.ArrayList;

public class StandardContainer {
    //ArrayList for standard containers
    ArrayList<String> standardContainer = new ArrayList<>();

    //This method is for loading container
    public void loadContainer(Cargo cargo) {
        System.out.println("\n+-----------------------------------------+");
        //For printing cargos
        cargo.printCargos();


    }
}
