import java.io.File;
import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {

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
