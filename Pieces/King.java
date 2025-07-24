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
     * @param color    0 for white, 1 for black
     * @param position Initial position in standard chess notation (e.g., "E1")
     */
    public King(int color, String position) {
        super(color, position);
    }

    /**
     * Always returns true for now (no move validation yet).
     *
     * @param toPosition The destination square
     * @return true (placeholder for now)
     */
    @Override
    public boolean isValidMove(String toPosition) {
        return true; // Movement validation not required in Phase 2
    }

    /**
     * Returns string representation for board display.
     * Uppercase for White, lowercase for Black.
     *
     * @return "K" or "k" depending on color
     */
    @Override
    public String toString() {
        return getColor() == 0 ? "K" : "k";
    }

    /**
     * Moves the piece to the given position.
     *
     * @param newPosition The new position object
     */
    @Override
    public void move(Position newPosition) {
        setPosition(newPosition.toString());
    }

    /**
     * Returns all possible moves for King (placeholder).
     *
     * @return An empty array (no logic needed yet)
     */
    @Override
    public String[] possibleMoves() {
        return new String[] {}; // TODO: Implement actual logic in Phase 3
    }
}
