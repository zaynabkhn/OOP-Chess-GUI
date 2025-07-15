package Pieces;

import java.util.ArrayList;
import java.util.List;

import Utilities.Position;
import Utils.Utils;

public class Rook extends Piece {

    public Rook(int color, String position) {
        this.color = color;
        this.position = position;
    }

    @Override
    public void possibleMoves() {
        System.out.println("Possible Rook moves from " + position + ":");

        int[] pos = Utils.toRowCol(position);
        int row = pos[0];
        int col = pos[1];

        int[][] directions = {
            {-1, 0}, {1, 0}, // up, down
            {0, -1}, {0, 1}  // left, right
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

                // To reference the board later
                System.out.println("Can move to: " + targetPos);

                // Future logic for checking board occupancy goes here
            }
        }
    }

    @Override
    public void move(Position newPos) {
        System.out.println("Rook moved to: " + newPos);
        // update this.position = newPos.toString();
    }
}
