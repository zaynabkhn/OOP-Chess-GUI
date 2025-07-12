package Pieces;

import java.util.ArrayList;
import java.util.List;

import Board.Board; // Assuming you’ll have a Board class with getPiece(row, col)
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

                // You’ll need to reference the board later
                System.out.println("Can move to: " + targetPos);

                // When Board is implemented:
                // Piece target = board.getPiece(r, c);
                // if (target == null) { add targetPos to list }
                // else if (target.color != this.color) { add and break }
                // else break;
            }
        }
    }

    @Override
    public void move() {
        System.out.println("Rook moved to new position (to be implemented).");
    }
}
