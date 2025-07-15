package Pieces;

import Utilities.Position; // Updating to add this
import Utils.Utils;

public class Bishop extends Piece {

    public Bishop(int color, String position) {
        this.color = color;
        this.position = position;
    }

    @Override
    public void possibleMoves() {
        System.out.println("Possible Bishop moves from " + position + ":");

        int[] pos = Utils.toRowCol(position);
        int row = pos[0];
        int col = pos[1];

        int[][] directions = {
            {-1, -1}, {-1, 1},
            {1, -1}, {1, 1}
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
            }
        }
    }

    @Override
    public void move(Position newPos) {
        System.out.println("Bishop moved to: " + newPos);
        // Add logic to update internal position if needed:
        // this.position = newPos.toString();
    }
}
