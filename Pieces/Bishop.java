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
        this.color = color;
        this.position = position;
    }

    /**
     * Displays all possible diagonal moves from the current position
     * (without checking for obstructions).
     * 
     * @param - none
     * @return - none
     */
    @Override
    public void possibleMoves() {
        System.out.println("Possible Bishop moves from " + position + ":");

        int[] pos = Utils.toRowCol(position);
        int row = pos[0];
        int col = pos[1];

        int[][] directions = {
            {-1, -1}, {-1, 1}, // upper-left, upper-right
            {1, -1}, {1, 1}    // lower-left, lower-right
        };

        for (int[] dir : directions) {
            int r = row;
            int c = col;

            while (true) {
                r += dir[0];
                c += dir[1];

                if (r < 0 || r >= 8 || c < 0 || c >= 8)
                    break;

                String targetPos = Utils.toPositionString(r, c);
                System.out.println("Can move to: " + targetPos);

                // TODO: Add board occupancy checks in future
            }
        }
    }

    /**
     * Moves the Bishop to the given position and prints a message.
     *
     * @param newPos The new position to move the Bishop to
     * @return - none
     */
    @Override
    public void move(Position newPos) {
        System.out.println("Bishop moved to: " + newPos);
        // Optionally update internal state
        // this.position = newPos.toString();
    }

    /**
     * Returns the character representing the Bishop for display on the board.
     *
     * @param - none
     * @return "B" for white bishop, "b" for black bishop
     */
    @Override
    public String toString() {
        return color == 0 ? "B" : "b";
    }
}
