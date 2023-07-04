package pieces;

public class Pawn {
    public static final String WHITE = "white";
    public static final String BLACK = "black";
    private String color = WHITE;

    /**
     * Constructs a default, white pawn
     *
     */
    public Pawn() {
    }

    public Pawn(String color) {
        this.color = color;
    }
    String getColor() {
        return color;
    }
}
