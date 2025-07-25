
package Pieces;

import Utilities.*;

/**
 * Represents a Bishop chess piece.
 * The Bishop can move diagonally in all directions.
 * This class extends the abstract Piece class.
 */

public class Bishop extends Piece {

    /**
     * Constructs a Bishop with a specified color and initial position.
     *
     * @param color - 0 for white, 1 for black
     * @param position - Initial position in standard chess notation (e.g., "C1")
     * @return - none
     */
    public Bishop(int color, String position) {
        super(color, position);
    }

    /**
     * Displays all possible diagonal moves from the current position
     * (without checking for obstructions).
     * 
     * @param - none
     * @return - none
     */
    
    // ZAINAB
    @Override
    public boolean isValidMove(String toPosition) {
        int fromCol = position.charAt(0) - 'A';
        int fromRow = 8 - Character.getNumericValue(position.charAt(1));
        int toCol = toPosition.charAt(0) - 'A';
        int toRow = 8 - Character.getNumericValue(toPosition.charAt(1));

        int rowDiff = Math.abs(toRow - fromRow);
        int colDiff = Math.abs(toCol - fromCol);

        // Bishop moves diagonally: difference in rows equals difference in columns
        return rowDiff == colDiff && rowDiff != 0;
    }

    @Override
    public String toString() {
        return color == 0 ? "B" : "b";
    }

    /**
     * Moves the Bishop to the given position and prints a message.
     *
     * @param newPos The new position to move the Bishop to
     * @return - none
     */
    public void move(Position newPosition) {
        setPosition(newPosition.toString());
    }

    /**
     * Returns the character representing the Bishop for display on the board.
     *
     * @param - none
     * @return "B" for white bishop, "b" for black bishop
     */
    public String[] possibleMoves() {
        return new String[] {};
    }
}
