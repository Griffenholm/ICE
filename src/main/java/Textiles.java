import java.util.ArrayList;

public class Textiles extends Textile {

    public Textiles(String textileName, String textileColor, String textileFabric, String textileComposition) {
        super(textileName, textileColor, textileFabric, textileComposition);

    }

    @Override
    public String toString() {
        return "Name: " + this.textileName + "\n" +
                "Color: " + this.textileColor + "\n" +
                "Fabric: " + this.textileFabric + "\n" +
                "Composition: " + this.textileComposition + "\n";
    }





}
