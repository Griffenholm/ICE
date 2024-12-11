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
    }

    public User getCurrentUser(){
        return currentUser;
    }





}
