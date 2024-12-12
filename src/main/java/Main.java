public class Main {
    public static void main(String[] args) {

        // Path to the service account JSON key google vision API
        System.setProperty("GOOGLE_APPLICATION_CREDENTIALS", "src/main/resources/service-account-api-key.json");

        TextileService s = new TextileService("TextileHouse");
        s.setup();



    }
}