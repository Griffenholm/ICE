public abstract class Textile {
    protected String textileName;
    protected String textileColor;
    protected String textileFabric;
    protected String textileComposition;



    public Textile(String textileName, String textileColor, String textileFabric, String textileComposition){

        this.textileName = textileName;
        this.textileColor = textileColor;
        this.textileFabric = textileFabric;
        this.textileComposition = textileComposition;

    }

    public String getTextileName() {
        return textileName;
    }


}
