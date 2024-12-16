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

   /* public static void userLogin(){
        TextUI.displayMsg("You have chosen to login");
        String username = TextUI.promptText("Please enter your username: ");
        String password = TextUI.promptText("Please enter your password: ");

        loadUsersFromCSV();
        System.out.println("cheking user : " + User.getUsername() +" with password: " + User.getPassword());

        for( User user : users){
            if(user.getUsername().equalsIgnoreCase(username) && user.getPassword().equalsIgnoreCase(password)){
                currentUser = user;
                TextUI.displayMsg("Login has been sucessful");
                return;
            }
        }
        TextUI.displayMsg("Login has failed. Username or password is incorrect");
        userLoginOrRegister();
    }*/

    //test 2 med login create and handle CSV file
    public static void userLogin(){
        TextUI.displayMsg("You have chosen to login");
        String username = TextUI.promptText("Please enter your username: ");
        String password = TextUI.promptText("Please enter your password: ");

        if(login(username,password)){
            TextUI.displayMsg("Login has been sucessful");
        }else{
            TextUI.displayMsg("Login has not been sucessful");
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



/*
    public static void userCreate(){

        loadUsersFromCSV();
        TextUI.displayMsg("You have chosen to create a new user");
        String username = User.username(users);
        String password = User.password();

        User newUser = new User(username, password);
        users.add(newUser);
        currentUser = newUser;
        FileIO.writeUserToCSV(newUser);
        TextUI.displayMsg("You have successfully been registered.");

    }


 */

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



    /*
    void startStreamingService() {
        ui.displayMsg("Welcome to " + this.name + "\n1. Make new user? \n2. Login on existing user?");

        int choice = ui.promptNumeric("Type 1 or 2.");

        if (choice == 1) { // Brugernes valg bliver gemt og tjekkes om hvilket nummer det er.
            createUser();
            homeMenu();
        } else if (choice == 2) {
            loadUserData();
        } else {
            ui.displayMsg("Sorry but that choice is invalid");
            // hvis ikke de skriver 1 eller 2, bliver dette her printet og funktionen bliver kaldt igen.
            startStreamingService();
        }
    }

    void createUser() {
        String username = ui.promptText("Type username:");
        while (username.length() < 4 || username.length() > 25) {
            ui.displayMsg("Username must be between 4 and 25 characters");
            username = ui.promptText("Type username:");
        }
        while (userData.containsKey(username)) { // Loop der altid tjekker om det nye username allerede eksistere.
            ui.displayMsg("Username already exists. Please choose different username");
            username = ui.promptText("Type username:");
            }
        String password = ui.promptText("Type password:");
        while (password.length() < 4 || password.length() > 25) {
            ui.displayMsg("Password must be between 4 and 25 characters");
            password = ui.promptText("Type password:");
        }
            currentUser = new User(username, password);
            this.addUser(currentUser);
        }


    public void addUser(User u) {
        FileIO.SaveUserData(u.toString(), this.userDataPath);
        // User (toString) vi lavet bliver sat i userData filen.
    }

    public void loadUserData() {
        if(!userData.isEmpty()) {
            String enteredUsername = ui.promptText("Type username:");
            String enteredPassword = ui.promptText("Type password:");
            if(userData.containsKey(enteredUsername) && userData.get(enteredUsername).equals(enteredPassword)){
                // Den if tjekker om det tastede username (key) eksistere. Herefter os tastede password stemmer overens med sin key.
                currentUser = new User(enteredUsername, enteredPassword);
                homeMenu();
            } else {
                ui.displayMsg("Username or password is wrong. Please try again");
                loadUserData();
            }
        } else {
            ui.displayMsg("Sorry, but we don't have any user yet. Please create on.");
            createUser();
        }
    }
    */

    public User getCurrentUser(){
        return currentUser;
    }

}
