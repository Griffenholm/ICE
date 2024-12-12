import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Load {
    //private ArrayList<User> users;
    private ArrayList<Textile> textiles;

    public Load(ArrayList<Textile> textiles) {
        //this.users = users;
        this.textiles = textiles;
    }


    /*public void loadUsers() {
        ArrayList<String> data = FileIO.readData("data/userdata.csv");
        for (String s : data) {
            String[] values = s.split(";");
            users.add(new User(values[0].trim(), values[1].trim(), Integer.parseInt(values[2].trim()), values[3].trim()));
        }
    }*/

    public void loadTextiles() {
        ArrayList<String> data = FileIO.readData("data/textiles.csv");
        for (String s : data) {
            String[] values = s.replace(" ", "").split(";");
            String textileName = values[0];
            String textileColor = values[1];
            String textileFabric = values[2];
            String textileComposition = values[3];
            /*float textileCost = Float.parseFloat(values[4].replace(",", "."));*/

            Textiles tmpSeries = new Textiles(textileName, textileColor, textileFabric, textileComposition);


            textiles.add(tmpSeries);

        }



    }


}
