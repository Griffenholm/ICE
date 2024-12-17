import java.util.ArrayList;

public class Textiles extends Textile {

    public Textiles(String textileName, String textileColor, String textileFabric, String textileComposition) {
        super(textileName, textileColor, textileFabric, textileComposition);

    }

    @Override
    public String toString() {
        return "Name: " + getTextileName() + "\n" +
                "Color: " + getTextileColor() + "\n" +
                "Fabric: " + getTextileFabric() + "\n" +
                "Composition: " + getTextileComposition() + "\n";
    }
}
