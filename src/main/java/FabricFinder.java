//I have installed the plugin Google Cloud Code to intelliJ.

import com.google.cloud.vision.v1.*;
import com.google.protobuf.ByteString;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FabricFinder {

    private final List<Textile> textileCatalog;

    // Constructor to initialize the textile catalog
    public FabricFinder(String csvFilePath) {
        this.textileCatalog = loadTextilesFromCSV(csvFilePath);
        if (textileCatalog.isEmpty()) {
            TextUI.displayMsg("No textiles loaded. Please check the CSV file.");
        }
    }



    // Run the Fabric Finder Service
    public void runFabricFinder() {
        //Check if catalog is loaded
        if (textileCatalog == null || textileCatalog.isEmpty()) {
            TextUI.displayMsg("Textile catalog is empty. Please check the CSV file.");
            return;
        }
        //Prompt user for file path (should also have a way to go back to menu)
        String filePath = TextUI.promptText("""
                Welcome to the Fabric Finder Service.
                Our AI will help you find the fabric you are looking for.
                Please enter the path of your fabric image file: 
                """);
        //Process the uploaded image
        processImage(filePath);
    }

    //Process the uploaded image file
    public void processImage(String filePath) {
        //Check if the file exists
        File file = new File(filePath);
        if (!file.isFile()) {
            TextUI.displayMsg("Invalid file path. Please try again");
            return;
        }

        //Call Google Vision API to get dominant RGB color
        int[] uploadedRGB = getDominantColorFromVisionAPI(filePath);
        if (uploadedRGB == null) {
            TextUI.displayMsg("Error analyzing the image. Please try again");
            return;
        }

        //Print detected RGB color
        TextUI.displayMsg("Detected RGB color: " + uploadedRGB[0] + ", " + uploadedRGB[1] + ", " + uploadedRGB[2]);


        //Identify the color
        String colorName = identifyColor(uploadedRGB);
        TextUI.displayMsg("Detected dominant color: " + colorName);

        //Find matching fabrics by comparing RGB
        List<Textile> matchedTextiles = getMatchingTextiles(uploadedRGB);

        //Display result
        if (matchedTextiles.isEmpty()) {
            TextUI.displayMsg("No matching fabrics found. Please try again");
        } else {
            TextUI.displayMsg("Matching fabrics: \n");
            for (Textile textile : matchedTextiles) {
                TextUI.displayMsg("\t" + textile.getTextileName() + "\n");
            }
        }
    }

    //Call Google Vision API to get the dominant RGB color
    private int[] getDominantColorFromVisionAPI(String filePath) {
        try {
            //Initialize the Vision API client
            try (ImageAnnotatorClient vision = ImageAnnotatorClient.create()) {
                //Read image data
                ByteString imgBytes = ByteString.readFrom(Files.newInputStream(Paths.get(filePath)));
                Image img = Image.newBuilder().setContent(imgBytes).build();

                //Perform Image Properties Detection
                Feature feature = Feature.newBuilder().setType(Feature.Type.IMAGE_PROPERTIES).build();
                AnnotateImageRequest request = AnnotateImageRequest.newBuilder()
                        .addFeatures(feature)
                        .setImage(img)
                        .build();
                List<AnnotateImageRequest> requests = new ArrayList<>();
                requests.add(request);

                //Get response
                BatchAnnotateImagesResponse response = vision.batchAnnotateImages(requests);
                AnnotateImageResponse res = response.getResponsesList().get(0);

                //Extract dominant color
                DominantColorsAnnotation colors = res.getImagePropertiesAnnotation().getDominantColors();
                ColorInfo color = colors.getColorsList().get(0); //Get the most dominant color
                return new int[]{
                        (int) color.getColor().getRed(),
                        (int) color.getColor().getGreen(),
                        (int) color.getColor().getBlue()
                };
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Identify the color based on RGB values (simplified to 3 colors)
    private String identifyColor(int[] rgb) {
        if (rgb[0] > rgb[1] && rgb[0] > rgb[2]) {
            return "Red";
        } else if (rgb[1] > rgb[0] && rgb[1] > rgb[2]) {
            return "Green";
        } else if (rgb[2] > rgb[0] && rgb[2] > rgb[1]) {
            return "Blue";
        } else {
            return "Unknown";
        }
    }

    //Find textiles with similar RGB (threshold comparison)
    private List<Textile> getMatchingTextiles(int[] uploadedRGB) {
        List<Textile> matchingTextiles = new ArrayList<>();
        for (Textile textile : textileCatalog) {
            if (isColorSimilar(uploadedRGB, textile.getRgb())) {
                matchingTextiles.add(textile);
            }
        }
        return matchingTextiles;
    }

    private boolean isColorSimilar(int[] rgb1, int[] rgb2) {
        int threshold = 50; //Adjust threshold as needed
        return Math.abs(rgb1[0] - rgb2[0]) <= threshold &&
                Math.abs(rgb1[1] - rgb2[1]) <= threshold &&
                Math.abs(rgb1[2] - rgb2[2]) <= threshold;
    }

    //Load textile data from a CSV file
    public static List<Textile> loadTextilesFromCSV(String fileName) {
        List<Textile> textiles = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            //Skip the first line (header)
            br.readLine(); //This skips the header

            while ((line = br.readLine()) != null) {
                //Spilt the line using simicolon
                String[] parts = line.split(";");

                //Validate CSV format: at least 7 fields (Name, Color, Fabric, Composition, Cost, Path, RGB)
                if (parts.length >=7 ){
                 //Extract fields
                 String textileName = parts[0].trim();
                 String color = parts[1].trim();
                 String fabric = parts[2].trim();
                 String composition = parts[3].trim();
                 String cost = parts[4].trim();
                 String path = parts[5].trim();
                 String rgbString = parts[6].trim();

                 //Parse the RGB values (split by comma)
                    String [] rgbParts = rgbString.split(",");
                    if (rgbParts.length == 3) {
                        try {
                            int red = Integer.parseInt(rgbParts[0].trim());
                            int green = Integer.parseInt(rgbParts[1].trim());
                            int blue = Integer.parseInt(rgbParts[2].trim());

                            //Add the needed fields to list
                            textiles.add(new Textile(textileName, path, new int[]{red, green, blue}));
                        } catch (NumberFormatException e) {
                            //If the RBG values are not valid
                            TextUI.displayMsg("Invalid RGB values for textile: " + textileName);
                        }
                    }else {
                        //If the RGB format is not valid
                        TextUI.displayMsg("Invalid RGB format for textile: " + textileName);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return textiles;
    }

}