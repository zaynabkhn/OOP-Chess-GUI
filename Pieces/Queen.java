package Pieces;

import Utilities.Position;

/**
 * Represents a Queen chess piece.
 * The Queen combines the power of a Rook and Bishop.
 * This class extends the abstract Piece class.
 */
public class Queen extends Piece {

    public Queen(int color, String position) {
        super(color, position);
    }

//  ZAINAB
    @Override
    public boolean isValidMove(String toPosition) {
        int fromCol = position.charAt(0) - 'A';
        int fromRow = 8 - Character.getNumericValue(position.charAt(1));
        int toCol = toPosition.charAt(0) - 'A';
        int toRow = 8 - Character.getNumericValue(toPosition.charAt(1));

        int rowDiff = Math.abs(toRow - fromRow);
        int colDiff = Math.abs(toCol - fromCol);

        // Queen moves like rook or bishop:
        // vertical/horizontal: same row or same column
        if (fromRow == toRow && fromCol != toCol) {
            return true; // horizontal move
        }
        if (fromCol == toCol && fromRow != toRow) {
            return true; // vertical move
        }
        // diagonal moves
        if (rowDiff == colDiff && rowDiff != 0) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return color == 0 ? "Q" : "q";
    }

    /**
     * Moves the Queen to the given position and prints a message.
     *
     * @param newPos - The new position to move the Queen to.
     * @return - none
     */
    public void move(Position newPosition) {
        setPosition(newPosition.toString());
    }

    /**
     * Lists the possible moves of a Queen chess piece.
     *
     * @param - none
     * @return - none
     */
    public String[] possibleMoves() {
        return new String[] {};
    }
}
