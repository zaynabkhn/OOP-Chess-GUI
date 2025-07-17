package Pieces;

/**
 * This is the abstract class Piece that works as the base for all pieces in the Chess game.
 */
public abstract class Piece {
    protected int color; // 0 for white, 1 for black
    protected String position;

    public Piece(int color, String position) {
        this.color = color;
        this.position = position;
    }

    public int getColor() {
        return color;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String newPosition) {
        this.position = newPosition;
    }

    public abstract boolean isValidMove(String toPosition);

    public abstract String toString();
}
