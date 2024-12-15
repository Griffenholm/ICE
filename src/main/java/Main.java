public class Main {
    public static void main(String[] args) {
        TextileService s = new TextileService("TextileHouse");
        Login.userLoginOrRegister();
        s.setup();

    }
}