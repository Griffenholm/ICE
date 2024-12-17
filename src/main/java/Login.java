import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Login {
    private static final String filePath = "usersdata.csv";
    private static ArrayList<User> users = new ArrayList<>();
    private static User currentUser;

    public Login() {
    }

    public static User userLoginOrRegister(){
        TextUI.displayMsg("Welcome to the Login or Registration Page");
        TextUI.displayMsg("Do you want to login or create a new user? \n" +
                "1. Login \n" +
                "2. Create a new user");

        int choice = TextUI.promptNumeric ( " Please choose between 1 or 2");

        if(choice == 1){
            userLogin();
        } else if(choice == 2){
            userCreate();
        }else{
            TextUI.displayMsg("Invalid option. Please choose between 1 or 2");
            userLoginOrRegister();
        }
        return currentUser;

    }

    //test 2 med login create and handle CSV file
    public static void userLogin(){
        TextUI.displayMsg("You have chosen to login");
        String username = TextUI.promptText("Please enter your username: ");
        String password = TextUI.promptText("Please enter your password: ");

        if(login(username,password)){
            TextUI.displayMsg("Login has been sucessful");
        }else{
            TextUI.displayMsg("Login has not been sucessful");
            userLoginOrRegister();
        }

    }

    public static void userCreate(){
        TextUI.displayMsg("You have chosen to create a new user");
        String username = TextUI.promptText("choose a username:");
        String password = TextUI.promptText("choose a password");

        if(userExists(username)){
            System.out.println("Username is already taken");
            userCreate();
        }else{
            User newUser = new User(username, password);
            FileIO.writeUserToCSV(newUser);
            System.out.println("You have successfully been registered.");
        }
    }

    // test 2 Check if a user exists in the CSV file
    static boolean userExists(String username) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userDetails = line.split(",");
                if (userDetails[0].equals(username)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the CSV file: " + e.getMessage());
        }
        return false;
    }

    // Login method to validate credentials from the CSV file
    private static boolean login(String username, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userDetails = line.split(",");
                if (userDetails[0].equals(username) && userDetails[1].equals(password)) {
                    return true; // Valid user
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the CSV file: " + e.getMessage());
        }
        return false; // User not found or invalid credentials
    }

    public static void loadUsersFromCSV() {
        // Clear the existing users list and load users from the file
        ArrayList<String> data = FileIO.readData("usersdata.csv");
        for (String line : data) {
            String[] userDetails = line.split(",");
            if (userDetails.length >= 2) {
                User user = new User(userDetails[0], userDetails[1]);
                users.add(user); // Add each user from CSV to the list
            }else{
                TextUI.displayMsg("Invalid user data in CSV" + line);
            }
        }
    }

    public User getCurrentUser(){
        return currentUser;
    }

}
