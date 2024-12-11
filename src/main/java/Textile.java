public abstract class Textile {
    private String textileName;

    public Textile(String textileName){

        this.textileName = textileName;
        System.out.println(this.textileName);

    }

    public String getTextileName() {
        return textileName;
    }


}
