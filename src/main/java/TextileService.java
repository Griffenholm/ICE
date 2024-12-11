import java.util.ArrayList;

public class TextileService {
    private String name;
    //private ArrayList<User> users;
    private ArrayList<Textile> textiles;
    private Load load;
    private String textilesDataPath;
    private String userDataPath;
    private String userData;
    private TextUI ui = new TextUI();
    private FileIO io = new FileIO();
    private TextileManager manager;
    private User currentUser;

    TextileService(String name) {
        this.name = name;
        this.textilesDataPath = "data/textiles.csv";
        this.userDataPath = "data/userData.csv";
        //this.userData = io.readUserData(this.userDataPath);

        this.textiles = new ArrayList<Textile>();
        this.load = new Load(textiles);

    }


    public void setup() {
        //load.loadUsers();
        load.loadTextiles();
        startTextileService();
    }

    void startTextileService(){
        ui.displayMsg("Welcome to " + this.name);

        homeMenu();

    }



    public void homeMenu() {
        //loadSavedlist(); // Loader savedlist med det samme
        this.manager = new TextileManager(ui, io, textilesDataPath, this, currentUser);
        int choice = ui.displayHomeMenu("Type a number:");
        switch (choice) {
            case 1:
                //TextUI.displayMsg("\nTextiles: ");
                ui.displayMsg("\nTextiles: ");
                textileCollection();

                break;
            case 2:
                manager.searchByTextiles();
                ui.displayMsg("Search");
                break;
            case 3:
                //manager.FabricFinder();
                ui.displayMsg("FabricFinder");
                break;
            case 4:
                ui.displayMsg("Profile");
                User.profileMenu(currentUser);
                break;
            case 5:
                //manager.textilelistInteraction(currentUser.getSavedlist(), "Savedlist");
                ui.displayMsg("Saved");
                break;
            case 6:
                ui.displayMsg("Checkout");
                break;
            case 7:
                ui.displayMsg("Logging out");
                break;
            default:
                ui.displayMsg("Choice invalid");
                homeMenu();
        }
    }

    public void textileCollection(){
        for (int i = 0; i < textiles.size(); i++){
            TextUI.displayMsg(i+1 + " " + textiles.get(i).getTextileName());
        }

    }




}
