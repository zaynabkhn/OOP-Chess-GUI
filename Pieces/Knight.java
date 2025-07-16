package Pieces;

import Utilities.Position;
import Utils.Utils;

/**
 * Represents a Knight chess piece.
 * Knights move in L-shaped patterns.
 */
public class Knight extends Piece {

    public Knight(int color, String position) {
        this.color = color;
        this.position = position;
    }

    @Override
    public void possibleMoves() {
        System.out.println("Possible Knight moves from " + position + ":");

        int[] pos = Utils.toRowCol(position);
        int row = pos[0];
        int col = pos[1];

        int[][] moves = {
            {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
            {1, -2},  {1, 2},  {2, -1},  {2, 1}
        };

        for (int[] move : moves) {
            int r = row + move[0];
            int c = col + move[1];
            if (Utils.isInBounds(r, c)) {
                System.out.println("Can move to: " + Utils.toPositionString(r, c));
            }
        }
    }

    @Override
    public void move(Position newPos) {
        System.out.println("Knight moved to: " + newPos);
    }

    @Override
    public String toString() {
        return color == 0 ? "N" : "n";
    }
}
