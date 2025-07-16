package Pieces;

import Utilities.Position;
import Utils.Utils;

/**
 * Represents a King chess piece.
 * The King can move one square in any direction.
 */
public class King extends Piece {

    public King(int color, String position) {
        this.color = color;
        this.position = position;
    }

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

    @Override
    public void move(Position newPos) {
        System.out.println("King moved to: " + newPos);
    }

    @Override
    public String toString() {
        return color == 0 ? "K" : "k";
    }
}
