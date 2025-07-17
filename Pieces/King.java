package Pieces;

import Utilities.Position;
/**
 * Represents a King chess piece.
 * The King can move one square in any direction.
 * This class extends the abstract Piece class.
 */

public class King extends Piece {

    /**
     * Constructs a King with a specified color and initial position.
     *
     * @param color - 0 for white, 1 for black
     * @param position - Initial position in standard chess notation (e.g., "C1")
     * @return - none
     */
    public King(int color, String position) {
        super(color, position);
    }

    @Override
    public boolean isValidMove(String toPosition) {
        // Placeholder logic
        return true;
    }

    /**
     * Gives a String "K" or "k" for the print depending on if the color is black or white.
     *
     * @param - none
     * @return If color == 0 (black), return "K", otherwise "k".
     */
    @Override
    public String toString() {
        return color == 0 ? "K" : "k";
    }

    /**
     * Outputs to show the new position.
     *
     * @param newPos - Object of type Position that gives the coordinate of the position of a piece.
     * @return - none
     */
    public void move(Position newPosition) {
        setPosition(newPosition.toString());
    }

    /**
     * Checks and prints the possible moves for the King.
     *
     * @param - none
     * @return - none
     */
    public String[] possibleMoves() {
        return new String[] {};
    }
}
