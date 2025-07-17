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

    @Override
    public boolean isValidMove(String toPosition) {
        // Placeholder logic
        return true;
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
