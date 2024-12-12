import java.util.ArrayList;

public class TextileService {
    private String name;
    //private ArrayList<User> users;
    private ArrayList<Textile> textiles;
    private Load load;
    private String textilesDataPath;
    private String userDataPath;
    private String userData;
    private TextUI ui = new TextUI();
    private FileIO io = new FileIO();
    private TextileManager manager;
    private User currentUser;
    private Menu menu;

    TextileService(String name) {
        this.name = name;
        this.textilesDataPath = "data/textiles.csv";
        this.userDataPath = "data/userData.csv";
        //this.userData = io.readUserData(this.userDataPath);
        this.textiles = new ArrayList<Textile>();
        this.menu = new Menu(textiles);
        this.load = new Load(textiles);

    }


    public void setup() {
        //load.loadUsers();
        load.loadTextiles();
        startTextileService();
    }

    void startTextileService(){
        ui.displayMsg("Welcome to " + this.name);

        menu.homeMenu();

    }

}
