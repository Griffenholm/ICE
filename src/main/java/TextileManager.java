import java.util.ArrayList;

public class TextileManager {

    private User currentUser;
    private ArrayList<Textile> textiles = new ArrayList<Textile>();
    private TextUI ui;
    private FileIO io;
    private TextileService textileService;
    private FabricFinder fabricFinder;

    TextileManager(TextUI ui, FileIO io, String textilesDataPath, User currentUser) {
        this.ui = ui;
        this.io = io;
        this.currentUser = currentUser;
    }



    public void searchByTextiles() {

    }

    /*public void textilelistInteraction() {

    }*/


}
