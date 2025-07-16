package Pieces;

import Utilities.Position;
import Utils.Utils;

/**
 * Represents a Queen chess piece.
 * The Queen combines the power of a Rook and Bishop.
 * This class extends the abstract Piece class.
 */
public class Queen extends Piece {

    public Queen(int color, String position) {
        this.color = color;
        this.position = position;
    }

    /**
     * Lists the possible moves of a Queen chess piece.
     *
     * @param - none
     * @return - none
     */
    @Override
    public void possibleMoves() {
        System.out.println("Possible Queen moves from " + position + ":");

        int[] pos = Utils.toRowCol(position);
        int row = pos[0];
        int col = pos[1];

        int[][] directions = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1},     
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}    
        };

        for (int[] dir : directions) {
            int r = row;
            int c = col;

            while (true) {
                r += dir[0];
                c += dir[1];

                if (!Utils.isInBounds(r, c)) break;

                System.out.println("Can move to: " + Utils.toPositionString(r, c));
                // In Phase 2: check for collisions
            }
        }
    }

    @Override
    public void move(Position newPos) {
        System.out.println("Queen moved to: " + newPos);
    }

    @Override
    public String toString() {
        return color == 0 ? "Q" : "q";
    }
}
