import java.util.ArrayList;
import java.util.Arrays;

public class Menu {
    private ArrayList<Textile> textiles;
    private static User currentUser;
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
                profileMenu(currentUser);
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


    public static int profileMenuOptions(){
        ArrayList<String> menu = new ArrayList<>(Arrays.asList("1.Kurv \n" +
                "2.Ordrehistorik \n" +
                "3.SavedList \n" +
                "4.Account"));
        TextUI.displayMsg("==ProfileMenu==");
        TextUI.displayMsg(String.valueOf(menu));
        return TextUI.promptNumeric("Please enter a number between 1 and 4");

    }

    public void profileMenu(User currentUser){
        int choice = profileMenuOptions();
        switch(choice){
            case 1:
                // kruv
                break;
            case 2:
                // OrdreHistroric
                break;
            case 3:
                // SavedList
                break;
            case 4:
                settingMenu();
                userSettingsUpdateOrExit();
                break;
            default:
                //if the user choose a diffent nr than 1 to 4.
                TextUI.displayMsg("Please enter a number between 1 and 4");
                break;
        }
    }

    public static void settingMenu(){
        TextUI.displayMsg("==Settings==\n" +
                "Username: " + User.getUsername() + "\n" +
                "Business Name: " + UserSettings.getBusinessName() + "\n" +
                "Contact Person: " + UserSettings.getContactPerson() +"\n" +
                "Email: " + UserSettings.getEmail()+"\n" +
                "Address: " + UserSettings.getAddress()+"\n" +
                "Postal Code: " + UserSettings.getPostalCode()+"\n" +
                "City: " + UserSettings.getCity()+"\n" +
                "Country: " + UserSettings.getCountry()+"\n" +
                "CVR Number: " + UserSettings.getCVRnr()+"\n" );
    }
    public User userSettingsUpdateOrExit(){
        TextUI.displayMsg("Do you want to update your info or exit to menu? \n" +
                "1. Update information\n" +
                "2. Exit");

        int choice = TextUI.promptNumeric ( " Please choose 1 or 2");

        if(choice == 1){
            //Update info

        } else if(choice == 2){
            homeMenu();
        }else{
            TextUI.displayMsg("Invalid option. Please choose between 1 or 2");
            userSettingsUpdateOrExit();
        }
        return currentUser;

    }



}
