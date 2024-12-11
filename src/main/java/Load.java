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
            /*String textileColor = values[1];
            String textileFabric = values[2];
            String textileComposition = values[3];
            float textileCost = Float.parseFloat(values[4].replace(",", "."));*/

            Textiles tmpSeries = new Textiles(textileName);





            textiles.add(tmpSeries);
            System.out.println(textileName);
            //medias.add(tmpSeries);

        }



    }



    public static <T>ArrayList<T> readTextileData(String path) {
        String name;
        String color;
        String fabric;
        String composition;
        double cost;
        ArrayList<T> textileData = new ArrayList<>();
        File file = new File(path);
        try {
            Scanner scan = new Scanner(file);
            scan.nextLine();//skip header
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] data = line.split(";"); //Name/Color/Fabric/Composition/Cost/Path/RGB
                name = data[0].trim();
                color = data[1].trim();
                fabric = (data[2].trim());
                composition = (data[3].trim());
                try {
                    String newCost = data[4].trim().replace(',', '.');
                    cost = Double.valueOf(newCost);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                //Textile newTextile = new Textile(name, color, fabric, composition, cost);
                //textileData.add((T) newTextile);



            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        }
        return textileData;
    }
}
