import java.util.ArrayList;


public class Login {
    private ArrayList<User> users;
    private User currentUser;

    public Login(ArrayList<User> users) {
        this.users = users;
    }

    public User userLoginOrRegister(){
        TextUI.displayMsg("Welcome to the Login or Registration Page");
        TextUI.displayMsg("Do you want to login or create a new user? \n" +
                "1. Login \n" +
                "2. Create a new user");

        int choice = TextUI.promptNumeric ( " Please choose between 1 or 2");

        if(choice == 1){
            userLogin();
            //homeMenu();
        } else if(choice == 2){
            userCreate();
            // homeMenu
        }else{
            TextUI.displayMsg("Invalid option. Please choose between 1 or 2");
            userLoginOrRegister();
        }
        return currentUser;

    }

    public void userLogin(){
        TextUI.displayMsg("You have chosen to login");
        String username = TextUI.promptText("Please enter your username: ");
        String password = TextUI.promptText("Please enter your password: ");

        for( User user : users){
            if(user.getUsername().equalsIgnoreCase(username) && user.getPassword().equalsIgnoreCase(password)){
                currentUser = user;
                return;
            }
        }
        TextUI.displayMsg("Login has failed. Username or password is incorrect");
        userLoginOrRegister();
    }

    public void userCreate(){
        TextUI.displayMsg("You have chosen to create a new user");
        String username = User.username(users);
        String password = User.password();

        User newUser = new User(username, password);
        users.add(newUser);
        currentUser = newUser;
        TextUI.displayMsg("You have successfully been registered.");

        //writeUserToCSV(newUser);
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
