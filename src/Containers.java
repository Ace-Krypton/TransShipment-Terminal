import java.util.ArrayList;

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

    //ArrayLists for containers
    ArrayList<String> standardContainer = new ArrayList<>();
    ArrayList<String> heavyContainer = new ArrayList<>();
    ArrayList<String> refrigeratedContainer = new ArrayList<>();
    ArrayList<String> liquidContainer = new ArrayList<>();
    ArrayList<String> explosiveContainer = new ArrayList<>();
    ArrayList<String> toxicPowderyContainer = new ArrayList<>();
    ArrayList<Cargo> toxicLiquidContainer = new ArrayList<>();
}
