package Pieces;

import Utilities.Position;

/**
 * Represents a Pawn chess piece.
 * The Pawn moves forward 1 square, or 2 squares from its initial position.
 * Attacks diagonally.
 * This class extends the abstract Piece class.
 */
public class Pawn extends Piece {

    /**
     * Constructs a Pawn Chess piece, using a given color and coordinate.
     *
     * @param color - 0 for white, 1 for black
     * @param position - Initial position in standard chess notation (e.g., "C1")
     * @return - none
     */
    public Pawn(int color, String position) {
        super(color, position);
    }

    @Override
    public boolean isValidMove(String toPosition) {
        // Placeholder logic
        return true;
    }

    @Override
    public String toString() {
        return color == 0 ? "P" : "p";
    }

    /**
     * Moves the Pawn to the given position and prints a message.
     *
     * @param newPos - The new position to move the Pawn to.
     * @return - none
     */
    public void move(Position newPosition) {
        setPosition(newPosition.toString());
    }

    /**
     * Lists the possible moves of a Pawn chess piece.
     *
     * @param - none
     * @return - none
     */
    public String[] possibleMoves() {
        return new String[] {};
    }
}
