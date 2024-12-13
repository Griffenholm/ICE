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
        //this.fabricFinder = new fabricFinder(textilesDataPath);
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
                fabricFinder.runFabricFinder();
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
        TextUI.displayMsg("==ProfileMenu==");
        TextUI.displayMsg("1.Kurv \n" +
                "2.Ordrehistorik \n" +
                "3.SavedList \n" +
                "4.Account");
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
                settingsMenu(currentUser);
                //FileIO.saveSettingsToCSV();
                break;
            default:
                //if the user choose a diffent nr than 1 to 4.
                TextUI.displayMsg("Please enter a number between 1 and 4");
                break;
        }
    }

   /* public static void settingsMenu(){
        TextUI.displayMsg("==Account==\n" +
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
    */

    public void settingsMenu(User currentUser){
        boolean exit = false; //to manage the menu while loop

        while(!exit){
            //display the settingsMenu
            TextUI.displayMsg("==Account==\n" +
            "1.  Username: " + User.getUsername() + "\n"+
            "2.  Business Name: " + UserSettings.getBusinessName() + "\n" +
            "3.  Contact Person: " + UserSettings.getContactPerson() +"\n" +
            "4.  Email: " + UserSettings.getEmail()+"\n" +
            "5.  Address: " + UserSettings.getAddress()+"\n" +
            "6.  Postal Code: " + UserSettings.getPostalCode()+"\n" +
            "7.  City: " + UserSettings.getCity()+"\n" +
            "8.  Country: " + UserSettings.getCountry()+"\n" +
            "9.  CVR Number: " + UserSettings.getCVRnr()+"\n" +
            "10. Exit");

            //promp the user for their choice
            int choice = TextUI.promptNumeric("Select the infomation you want to update (1-10): ");

            //Use a switch-case for single updates
            switch(choice){
                case 1:
                    String updateUsername = TextUI.promptText("Enter new username: ");
                    User.setUsername(updateUsername);
                    TextUI.displayMsg("Username is now updated");
                    break;
                case 2:
                    String updateBusinessname = TextUI.promptText("Enter new Business name: ");
                    UserSettings.setBusinessName(updateBusinessname);
                    TextUI.displayMsg("Business name is now updated");
                    break;
                case 3:
                    String updateContactPerson = TextUI.promptText("Enter new Contact Person: ");
                    UserSettings.setContactPerson(updateContactPerson);
                    TextUI.displayMsg("Contact Person is now updated");
                    break;
                case 4:
                    String updateEmail = TextUI.promptText("Enter new Email add. : ");
                    UserSettings.setEmail(updateEmail);
                    TextUI.displayMsg("Email add. is now updated");
                    break;
                case 5:
                    String updateAddress = TextUI.promptText("Enter new Address: ");
                    UserSettings.setAddress(updateAddress);
                    TextUI.displayMsg("Address is now updated");
                    break;
                case 6:
                    int updatePostalCode = TextUI.promptNumeric("Enter new PostalCode: ");
                    UserSettings.setPostalCode(updatePostalCode);
                    TextUI.displayMsg("PostalCode is now updated");
                    break;
                case 7:
                    String updateCity = TextUI.promptText("Enter new City: ");
                    UserSettings.setCity(updateCity);
                    TextUI.displayMsg("City is now updated");
                    break;
                case 8:
                    String updateCountry = TextUI.promptText("Enter new Country: ");
                    UserSettings.setCountry(updateCountry);
                    TextUI.displayMsg("Country is now updated");
                    break;
                case 9:
                    int updateCVRnr = TextUI.promptNumeric("Enter new Contact Person: ");
                    UserSettings.setCVRnr(updateCVRnr);
                    TextUI.displayMsg("Contact Person is now updated");
                    break;
                case 10:
                    // Exit to the homeMenu
                    exit = true;
                    TextUI.displayMsg("Exiting settings menu.");
                    homeMenu();
                    break;
                default:
                    TextUI.displayMsg("Invalid option. Please choose a number between 1 and 10.");
                    break;
            }
           // FileIO.saveSettingsToCSV(User.getSettings(), "settings.csv");
        }
    }




}
