import java.util.Arrays;

public class Textile {

    private String textileName;
    private String path;
    private int[] rgb;
    private String textileColor;
    private String textileFabric;
    private String textileComposition;

    // Constructor for uploaded textiles
    public Textile(String textileName, String path, int[] rgb){
        if (textileName == null || path == null || rgb == null){
            throw new IllegalArgumentException("Invalid data provided.");
        }
        this.textileName = textileName;
        this.path = path;
        this.rgb = Arrays.copyOf(rgb, rgb.length);
    }

    // Constructor for textile products
    public Textile(String textileName, String textileColor, String textileFabric, String textileComposition){
        if (textileName == null || textileColor == null || textileFabric == null || textileComposition == null){
            throw new IllegalArgumentException ("Invalid data provided.");
        }
        this.textileName = textileName;
        this.textileColor = textileColor;
        this.textileFabric = textileFabric;
        this.textileComposition = textileComposition;
    }

    //Getters
    public String getTextileName(){
        return textileName;
    }

    public String getPath(){
        return path;
    }

    public int[] getRgb(){
        return rgb !=null ? Arrays.copyOf(rgb, rgb.length) : null; //Checks if the rgb is not null. If the method is null, it returns null. It insures that I don't attempt to copy a non-existent array which will cause a NullPointerException.
    }

    public String getTextileFabric() {
        return textileFabric;
    }

    public String getTextileComposition() {
        return textileComposition;
    }

}
