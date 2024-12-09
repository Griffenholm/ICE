import java.util.ArrayList;

public class User {

    private String username;
    private String password;
    ArrayList<Textile> savedList;
    ArrayList<Textile> getOrder;
    private int id;
    private static int idCounter = 1;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.savedList = new ArrayList<>();
        this.getOrder = new ArrayList<>();
        this.id = idCounter++;
    }
    public String getUsername(){
        return username;
    }

    @Override
    public String toString(){
        return username + ";" + password;
    }



}
