package Pieces;

import Utilities.Position;
import Utils.Utils;

/**
 * Represents a Pawn chess piece.
 * The Pawn moves forward 1 square, or 2 squares from its initial position.
 */
public class Pawn extends Piece {

    public Pawn(int color, String position) {
        this.color = color;
        this.position = position;
    }

    @Override
    public void possibleMoves() {
        System.out.println("Possible Pawn moves from " + position + ":");

        int[] pos = Utils.toRowCol(position);
        int row = pos[0];
        int col = pos[1];

        int direction = (color == 0) ? -1 : 1; // white moves up, black down

        // 1 step forward
        int oneStep = row + direction;
        if (Utils.isInBounds(oneStep, col))
            System.out.println("Can move to: " + Utils.toPositionString(oneStep, col));

        // 2 steps forward if on starting row
        boolean startingRow = (color == 0 && row == 6) || (color == 1 && row == 1);
        if (startingRow) {
            int twoStep = row + 2 * direction;
            if (Utils.isInBounds(twoStep, col))
                System.out.println("Can move to: " + Utils.toPositionString(twoStep, col));
        }

        // Capture moves (diagonal) – no validation yet
        if (Utils.isInBounds(row + direction, col - 1))
            System.out.println("Can capture at: " + Utils.toPositionString(row + direction, col - 1));
        if (Utils.isInBounds(row + direction, col + 1))
            System.out.println("Can capture at: " + Utils.toPositionString(row + direction, col + 1));
    }

    @Override
    public void move(Position newPos) {
        System.out.println("Pawn moved to: " + newPos);
    }

    @Override
    public String toString() {
        return color == 0 ? "P" : "p";
    }
}
