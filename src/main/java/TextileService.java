public class TextileService {
    private String name;
    private String textilesDataPath;
    private String userDataPath;
    private String userData;
    private TextUI ui = new TextUI();
    private FileIO io = new FileIO();
    private TextileManager manager;

    TextileService(String name) {
        this.name = name;
        this.textilesDataPath = "data/textiles.csv";
        this.userDataPath = "data/userData.csv";
        //this.userData = io.readUserData(this.userDataPath);

    }

    void startTextileService(){
        ui.displayMsg("Welcome to " + this.name);

    }
}
