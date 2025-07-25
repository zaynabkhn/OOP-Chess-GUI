package Pieces;

import Utilities.Position;

/**
 * Represents a Knight chess piece, and Knights move in L-shaped patterns.
 * The Knight can move in an 'L' in any direction.
 * This class extends the abstract Piece class.
 */
public class Knight extends Piece {

    /**
     * Constructs a Knight Chess piece, using a given color and coordinate.
     *
     * @param color - 0 for white, 1 for black
     * @param position - Initial position in standard chess notation (e.g., "C1")
     * @return - none
     */
    public Knight(int color, String position) {
        super(color, position);
    }

    // ZAINAB
    @Override
    public boolean isValidMove(String toPosition) {
        int fromCol = position.charAt(0) - 'A';
        int fromRow = 8 - Character.getNumericValue(position.charAt(1));
        int toCol = toPosition.charAt(0) - 'A';
        int toRow = 8 - Character.getNumericValue(toPosition.charAt(1));

        int rowDiff = Math.abs(toRow - fromRow);
        int colDiff = Math.abs(toCol - fromCol);

        // Knight moves in L shape: 2 by 1 or 1 by 2
        return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);
    }

    /**
     * Returns the String that respresnts the Knight depending on color.
     *
     * @param - one
     * @return String - If color == 0 (black), return "N", "n" otherwise.
     */
    @Override
    public String toString() {
        return color == 0 ? "N" : "n";
    }

     /**
     * Prints the new location that the Knight piece has moved to.
     *
     * @param newPos - A coordinate of type Position that holds the location of where the Knight moves.
     * @return - none
     */
    public void move(Position newPosition) {
        setPosition(newPosition.toString());
    }

    /**
     * Lists the possible moves of a Knight chess piece.
     *
     * @param - none
     * @return - none
     */
    public String[] possibleMoves() {
        return new String[] {};
    }
}
