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

    public void containerMenu() {
        System.out.println("\n+-----------------------------------------+");
        System.out.println("[1] Load Cargo To Standard Container");
        System.out.println("[2] Load Cargo To Heavy Container");
        System.out.println("[3] Load Cargo To Liquid Container");
        System.out.println("[4] Load Cargo To Refrigerated Container");
        System.out.println("[5] Load Cargo To Explosive Container (This is the one working right now)");
        System.out.println("[6] Load Cargo To Toxic Container");
        System.out.println("[A] Back");
        System.out.println("\n+-----------------------------------------+");
    }
}
