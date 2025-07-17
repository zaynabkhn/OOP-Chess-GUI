package Pieces;

import Utilities.Position;

/**
 * Represents a Queen chess piece.
 * The Queen combines the power of a Rook and Bishop.
 * This class extends the abstract Piece class.
 */
public class Queen extends Piece {

    public Queen(int color, String position) {
        super(color, position);
    }

    @Override
    public boolean isValidMove(String toPosition) {
        // Placeholder logic
        return true;
    }

    @Override
    public String toString() {
        return color == 0 ? "Q" : "q";
    }

    /**
     * Moves the Queen to the given position and prints a message.
     *
     * @param newPos - The new position to move the Queen to.
     * @return - none
     */
    public void move(Position newPosition) {
        setPosition(newPosition.toString());
    }

    /**
     * Lists the possible moves of a Queen chess piece.
     *
     * @param - none
     * @return - none
     */
    public String[] possibleMoves() {
        return new String[] {};
    }
}
