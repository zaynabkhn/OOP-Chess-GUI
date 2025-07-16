package Pieces;

import Utilities.Position;
import Utils.Utils;

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
        this.color = color;
        this.position = position;
    }

    /**
     *  Displays all possible horizontal and vertical moves
     *  from the current position (without checking for obstructions).
     *
     * @param - none
     * @return - none
     */
    @Override
    public void possibleMoves() {
        System.out.println("Possible Rook moves from " + position + ":");

        int[] pos = Utils.toRowCol(position);
        int row = pos[0];
        int col = pos[1];

        int[][] directions = {
            {-1, 0}, {1, 0}, // vertical (up, down)
            {0, -1}, {0, 1}  // horizontal (left, right)
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
     * Moves the Rook to the given position and prints a message.
     *
     * @param newPos The new position to move the Rook to.
     * @return - none
     */
    @Override
    public void move(Position newPos) {
        System.out.println("Rook moved to: " + newPos);
        // Optionally update internal state
        // this.position = newPos.toString();
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
}

