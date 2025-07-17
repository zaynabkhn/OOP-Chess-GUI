package Pieces;

import Utilities.*;

/**
 * Represents a Knight chess piece, and Knights move in L-shaped patterns.
 * The Knight can move in an 'L' in any direction.
 * This class extends the abstract Piece class.
 */
public class Knight extends Piece 
{
    /**
     * Constructs a Knight Chess piece, using a given color and coordinate.
     *
     * @param color - 0 for white, 1 for black
     * @param position - Initial position in standard chess notation (e.g., "C1")
     * @return - none
     */
    public Knight(int color, String position) 
    {
        this.color = color;
        this.position = position;
    }

    /**
     * Lists the possible moves of a Knight chess piece.
     *
     * @param - none
     * @return - none
     */
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

    /**
     * Prints the new location that the Knight piece has moved to.
     *
     * @param newPos - A coordinate of type Position that holds the location of where the Knight moves.
     * @return - none
     */
    @Override
    public void move(Position newPos) {
        System.out.println("Knight moved to: " + newPos);
    }

    /**
     * Returns the String that respresnts the Knight depending on color.
     *
     * @param - one
     * @return String - If color == 0 (black), return "N", "n" otherwise.
     */
    @Override
    public String toString() {
        return color == 0 ? "N" : "n";
    }
}
