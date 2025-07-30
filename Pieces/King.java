package Pieces;

import Utilities.Position;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a King chess piece.
 * The King can move one square in any direction.
 * This class extends the abstract Piece class.
 */
public class King extends Piece {

    /**
     * Constructs a King with a specified color and initial position.
     *
     * @param color    0 for white, 1 for black
     * @param position Initial position in standard chess notation (e.g., "E1")
     */
    public King(int color, String position) {
        super(color, position);
    }

    /**
     * Returns the string representation of the King for board display.
     * "wK" for white, "bK" for black.
     *
     * @return "wK" or "bK" depending on color
     */
    @Override
    public String toString() {
        return (color == 0 ? "w" : "b") + "K";
    }

    /**
     * Checks whether a move is valid for the King.
     * The King moves exactly one square in any direction (horizontal, vertical, diagonal),
     * and cannot move to a square occupied by a piece of the same color.
     *
     * @param toPosition The destination position in standard chess notation (e.g., "D1")
     * @param board      The current state of the board
     * @return true if the move is valid, false otherwise
     */
    @Override
    public boolean isValidMove(String toPosition, Piece[][] board) {
        int fromCol = position.charAt(0) - 'A';
        int fromRow = 8 - Character.getNumericValue(position.charAt(1));
        int toCol = toPosition.charAt(0) - 'A';
        int toRow = 8 - Character.getNumericValue(toPosition.charAt(1));

        int rowDiff = Math.abs(toRow - fromRow);
        int colDiff = Math.abs(toCol - fromCol);

        if (rowDiff <= 1 && colDiff <= 1) {
            Piece destination = board[toRow][toCol];
            return destination == null || destination.getColor() != this.color;
        }

        return false;
    }

    /**
     * Moves the King to the given position.
     *
     * @param newPosition The new position to move the King to
     */
    @Override
    public void move(Position newPosition) {
        setPosition(newPosition.toString());
    }

    /**
     * Returns all valid moves for the King as an array of strings.
     * A valid move is any adjacent square not occupied by the same color.
     *
     * @param board The current game board
     * @return An array of valid move positions (e.g., {"E2", "D1"})
     */
    @Override
    public String[] possibleMoves(Piece[][] board) {
        ArrayList<String> moves = new ArrayList<>();
        int row = 8 - Character.getNumericValue(position.charAt(1));
        int col = position.charAt(0) - 'A';

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (dr == 0 && dc == 0) continue;
                int r = row + dr;
                int c = col + dc;
                if (r >= 0 && r < 8 && c >= 0 && c < 8) {
                    String toPos = "" + (char) ('A' + c) + (8 - r);
                    if (isValidMove(toPos, board)) {
                        moves.add(toPos);
                    }
                }
            }
        }

        return moves.toArray(new String[0]);
    }

    /**
     * Returns all valid Position objects the King can move to.
     * The King moves one square in any direction, and cannot land on a square
     * occupied by a piece of the same color.
     *
     * @param board The Board object representing the current game state
     * @return A list of valid Position objects
     */
    @Override
    public List<Position> getValidMoves(Board.Board board) {
        List<Position> moves = new ArrayList<>();
        int row = 8 - Character.getNumericValue(position.charAt(1));
        int col = position.charAt(0) - 'A';

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (dr == 0 && dc == 0)
                    continue;
                int r = row + dr;
                int c = col + dc;
                if (r >= 0 && r < 8 && c >= 0 && c < 8) {
                    Position newPos = new Position(r, c);
                    Piece target = board.getPiece(newPos);
                    if (target == null || target.getColor() != this.color) {
                        moves.add(newPos);
                    }
                }
            }
        }

        return moves;
    }
}
