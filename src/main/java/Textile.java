public class Textile {

    private final String name;
    private final String path;
    private final int[] rgb;

    public Textile(String name, String path, int[] rgb){
        this.name = name;
        this.path = path;
        this.rgb = rgb;
    }

    public String getName(){
        return name;
    }

    public String getPath(){
        return path;
    }

    public int[] getRgb(){
        return rgb;
    }
}
