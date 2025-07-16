package Pieces;

import Utilities.Position;
import Utils.Utils;

/**
 * Represents a King chess piece.
 * The King can move one square in any direction.
 * This class extends the abstract Piece class.
 */
public class King extends Piece {

    public King(int color, String position) {
        this.color = color;
        this.position = position;
    }

    /**
     * Checks and prints the possible moves for the King.
     *
     * @param - none
     * @return - none
     */
    @Override
    public void possibleMoves() {
        System.out.println("Possible King moves from " + position + ":");

        int[] pos = Utils.toRowCol(position);
        int row = pos[0];
        int col = pos[1];

        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                if ((r != row || c != col) && Utils.isInBounds(r, c)) {
                    System.out.println("Can move to: " + Utils.toPositionString(r, c));
                }
            }
        }
    }

    /**
     * Outputs to show the new position.
     *
     * @param newPos - Object of type Position that gives the coordinate of the position of a piece.
     * @return - none
     */
    @Override
    public void move(Position newPos) {
        System.out.println("King moved to: " + newPos);
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
}
