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
    public static void saveSettingsToCSV(UserSettings details,String filePath) {
        try(FileWriter writer = new FileWriter(filePath,true)) {
            String csvRow = String.join(",",
                    details.getAccount().getUsername(),        //username
                    details.getAccount().getPassword(),        //password
                    details.getBusinessName(),                 //Businessname
                    details.getContactPerson(),                //contact person
                    details.getEmail(),                        //email
                    details.getAddress(),                      //address
                    String.valueOf(details.getPostalCode()),   //postal code
                    details.getCity(),                         //city
                    details.getCountry(),                      //country
                    String.valueOf(details.getCVRnr())        //CVR NR
            );
            //to go to next line with new info
            writer.write(csvRow + "\n");

        }catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error saving to th CSV");
        }
    }


}
