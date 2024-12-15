import java.util.ArrayList;
import java.util.Arrays;


public class User {

    private static String username = "Not provided yet";
    private static String password;
    ArrayList<Textile> savedList;
    ArrayList<Textile> getOrder;
    private int UserID;
    private static int UserIDCounter = 1;
    public User currentUser;
    private static ArrayList<User> users = new ArrayList<>();



    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.savedList = new ArrayList<>();
        this.getOrder = new ArrayList<>();
        this.UserID = UserIDCounter++;
    }
    public static String getUsername(){
        return username;
    }

    public static void setUsername(String newusername){
        username = newusername;
    }

    public String getPassword(){
        return password;
    }



    @Override
    public String toString(){
        return username + ";" + password;
    }


    // the 2 methode below is for creating a new user
    // to check if the username is taken
    public static String username(ArrayList<User> users) {
        //version 1, virker ikke ordenligt
        while (true) {
            String username = TextUI.promptText("Please enter username: ");
            if (isUsernameUnique(username, users)) {
                return username;
            } else {
                TextUI.displayMsg("The username is already taken, please chose another one.");
            }
        }
        //version 2 virker ikke ordenligt

       /* String username;
        boolean isUnique;

        // Keep prompting the user until a unique username is provided
        do {
            username = TextUI.promptText("Please enter username: ");
            isUnique = checkForDuplicateUsername(username,users);  // Check for duplicates
            if (!isUnique) {
                TextUI.displayMsg("The username is already taken, please choose another one.");
            }
        } while (!isUnique);  // Repeat if username is not unique

        return username;  // Return the unique username

        */
    }

    public static boolean isUsernameUnique(String username,ArrayList<User> users) {
        return users.stream().noneMatch(u->u.getUsername().equalsIgnoreCase(username));
    }
    public static boolean checkForDuplicateUsername(String username,ArrayList<User> users) {
        for (User u : users) {
            if (u.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
       return false;
    }

    //to make the password more secure
    public static String password() {
        String password = TextUI.promptText("Please enter password: ");
        if (password.length() < 6 /*|| !password.matches(".*[0-9].*") || !checkUpperCase(password)*/){
            TextUI.displayMsg("Password must be at least 6 character" + /*, contain a number and one capital letter.*/" Please try again");
            password = password();
        }
        return password;
    }

    public static boolean checkUpperCase(String password){
        char character;
        for (int i = 0; i < password.length(); i++){
            character = password.charAt(i);
            if (Character.isUpperCase(character)) {
                return true;
            }
        }
        return false;
    }


}
