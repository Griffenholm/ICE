public class TextileService {
    private String name;
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

    }

    void startTextileService(){
        ui.displayMsg("Welcome to " + this.name);

        homeMenu();

    }



    public void homeMenu() {
        //loadSavedlist(); // Loader savedlist med det samme
        //this.manager = new TextileManager(ui, io, textileDataPath, this, currentUser);
        int choice = ui.displayHomeMenu("Type a number:");
        switch (choice) {
            case 1:
                manager.textileCollection();
                ui.displayMsg("Textiles");
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
}
