import java.util.ArrayList;

public class Menu {
    private ArrayList<Textile> textiles;
    private User currentUser;
    private TextUI ui = new TextUI();
    private FileIO io = new FileIO();

    private String textilesDataPath;
    private TextileManager manager;

    private Textile currentTextile;
    private FabricFinder fabricFinder;


    public Menu(ArrayList<Textile> textiles) {

        this.textilesDataPath = "data/textiles.csv";
        this.textiles = textiles;

        this.manager = manager;
        //this.fabricFinder = fabricFinder;
        //this.users = users;
        //this.search = new Search();
    }

    public void homeMenu() {
        //loadSavedlist(); // Loader savedlist med det samme
        this.manager = new TextileManager(ui, io, textilesDataPath, currentUser);
        int choice = ui.displayHomeMenu("Type a number:");
        switch (choice) {
            case 1:
                //TextUI.displayMsg("\nTextiles: ");
                ui.displayMsg("\nTextiles: ");
                textileCollection();
                selectTextile();
                break;
            case 2:
                manager.searchByTextiles();
                ui.displayMsg("Search");
                break;
            case 3:
                ui.displayMsg("FabricFinder");
                fabricFinder.startFabricFinder();
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

    public void selectTextile(){
        int choice = TextUI.promptNumeric("\nPlease write the number of the series you want to choose: ");
        try{
            currentTextile = textiles.get(choice - 1);
            TextUI.displayMsg("\nYou selected: " + currentTextile.getTextileName()+"\n");
            displayTextileInformation();

        }catch (IndexOutOfBoundsException e){
            textileCollection();
            TextUI.displayMsg("\nInvalid choice. Please select a number from the list.");
            selectTextile();
        }
    }

    public void displayTextileInformation() {
        ui.displayMsg(currentTextile.toString());

        int choice = ui.promptNumeric("What do you want to do?\n1. \uD83D\uDED2 Buy\n2. ♥ Add to favorites\n3. ⌂ Go back home");

        switch (choice) {
            case 1:
                //BuyTextile();
                break;
            case 2:
                //currentUser.addToSavedlist();
                ui.displayMsg("\nHome Menu:");
                homeMenu();
                break;
            case 3:
                ui.displayMsg("\nHome Menu:");
                homeMenu();
                break;
            default:
                ui.displayMsg("Invalid choice. Going back...");
                homeMenu();
        }

    }



}
