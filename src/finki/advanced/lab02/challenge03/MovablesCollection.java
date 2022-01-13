package finki.advanced.lab02.challenge03;

public class MovablesCollection {
    private Movable[] movables;
    public static int xMAX = 0;
    public static int yMAX = 0;

    public MovablesCollection(int xMAX, int yMAX) {
        MovablesCollection.xMAX = xMAX;
        MovablesCollection.yMAX = yMAX;
        this.movables = new Movable[0];
    }
}
