
package Pieces;

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

                // For now, just print possible squares
                // In Phase 2, you'd check board for collisions and captures
                System.out.println("Can move to: " + targetPos);
            }
        }
    }

    @Override
    public void move() {
        System.out.println("Bishop moved to new position (to be implemented).");
    }
}
