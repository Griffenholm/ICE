import java.io.File;
import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.io.IOException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {

    public static ArrayList<String> readData(String path) {
        ArrayList<String> data = new ArrayList<>();
        File file = new File(path);
        try{
            Scanner scan = new Scanner(file);
            scan.nextLine();//skip header

            while (scan.hasNextLine())  {
                String line = scan.nextLine();
                data.add(line);

            }
        } catch (FileNotFoundException e){
            System.out.println("File was not found");
        }
        return data;
    }

}
