import java.util.ArrayList;

public class TextileManager {

    private User currentUser;
    private ArrayList<Textile> textiles = new ArrayList<Textile>();
    private TextUI ui;
    private FileIO io;
    private TextileService textileService;

    TextileManager(TextUI ui, FileIO io, String textilesDataPath, TextileService textileService, User currentUser) {
        this.ui = ui;
        this.io = io;
        //this.textiles = io.readTextileData(textilesDataPath, "Textile");
        this.textileService = textileService;
        this.currentUser = currentUser;
    }



    public void searchByTextiles() {

    }

    /*public void textilelistInteraction() {

    }*/
}
