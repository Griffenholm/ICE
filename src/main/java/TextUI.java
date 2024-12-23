import java.util.Scanner;

public class TextUI {
    private static Scanner scan = new Scanner(System.in);

    public static void displayMsg(String msg){
        System.out.println(msg);
    }

    public int displayHomeMenu(String msg) {
        displayMsg("1. Textiles \n2. Search \n3. FabricFinder\n4. Profile\n5. \n6. Checkout \n7. Log out");
        int choice = promptNumeric(msg);
        return choice;
    }

    public static int promptNumeric(String msg) {
        System.out.println(msg);     //Brugeren stilles et spørgsmål
        String input = scan.nextLine();
        int number;
        // Giver brugeren et sted at placere sit svar og vente på svaret
        try {
            number = Integer.parseInt(input);
        }
        catch(NumberFormatException e){
            displayMsg("Please type a number");
            number = promptNumeric(msg);
        }
        return number;
    }

    public static String promptText(String msg){
        System.out.println(msg);    //Brugeren stilles et spørgsmål
        String input = scan.nextLine();
        return input;
    }
}
