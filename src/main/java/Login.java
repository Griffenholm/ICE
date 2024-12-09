import java.util.ArrayList;


public class Login {
    private ArrayList<User> users;
    private User currentUser;

    public Login(ArrayList<User> users) {
        this.users = users;
    }

    public User userLoginOrRegister(){
        TextUI.displayMsg("Do you want to login or create a new user? \n" +
                "1. Login \n" +
                "2. Create a new user");

        int choice = TextUI.promptNumeric ( " Please choose between 1 or 2");

        if(choice == 1){
           // UserLogin();

        }
    }



}
