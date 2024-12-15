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

    public static String getPassword(){
        return password;
    }



    @Override
    public String toString(){
        return username + ";" + password;
    }


    // the 2 methode below is for creating a new user
    // to check if the username is taken
    public static String username(ArrayList<User> users) {
        //version 1,
        while (true) {
            String username = TextUI.promptText("Please enter username: ");
            if (isUsernameUnique(username, users)) {
                return username;
            } else {
                TextUI.displayMsg("The username is already taken, please chose another one.");
            }
        }

    }

    public static boolean isUsernameUnique(String username,ArrayList<User> users) {
        for (User u : users) {
            if (u.getUsername().equalsIgnoreCase(username)) {
                return false;
            }
        }
       return true;
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
