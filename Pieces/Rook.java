package Pieces;

import Utilities.Position;

/**
 * Represents a Rook chess piece.
 * The Rook can move any number of squares horizontally or vertically.
 * This class extends the abstract Piece class.
 */
public class Rook extends Piece {

    /**
     * Constructs a Rook with a specified color and initial position.
     *
     * @param color    0 for white, 1 for black
     * @param position Initial position in standard chess notation (e.g., "A1")
     */
    public Rook(int color, String position) {
        super(color, position);
    }

    @Override
    public boolean isValidMove(String toPosition) {
        // Stub logic – just return true for now
        return true;
    }

    /**
     * Returns the character representing the Rook for display on the board.
     *
     * @return "R" for white rook, "r" for black rook
     */
    @Override
    public String toString() {
        return color == 0 ? "R" : "r";
    }

    /**
     *  Displays all possible horizontal and vertical moves
     *  from the current position (without checking for obstructions).
     *
     * @param - none
     * @return - none
     */
    public String[] possibleMoves() {
        // You can implement real logic later
        return new String[] {};
    }

    /**
     * Moves the Rook to the given position and prints a message.
     *
     * @param newPos The new position to move the Rook to.
     * @return - none
     */
    public void move(Position newPosition) {
        setPosition(newPosition.toString()); 
    }
}
