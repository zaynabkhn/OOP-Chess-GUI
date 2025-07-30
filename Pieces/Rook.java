package Pieces;

import Utilities.Position;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Rook chess piece.
 * The Rook can move any number of squares horizontally or vertically.
 * This class extends the abstract Piece class.
 */
public class Rook extends Piece {

    /**
     * Constructs a Rook with a specified color and initial position.
     *
     * @param color    0 for white, 1 for black
     * @param position Initial position in standard chess notation (e.g., "A1")
     */
    public Rook(int color, String position) {
        super(color, position);
    }

    /**
     * Checks if a move is valid for the Rook, taking into account board boundaries and obstructions.
     * A valid move is along the same row or column, and must not jump over other pieces.
     *
     * @param toPosition The destination position in standard chess notation (e.g., "A4")
     * @param board      The current game board represented as a 2D array of Piece objects
     * @return true if the move is valid, false otherwise
     */
    @Override
    public boolean isValidMove(String toPosition, Piece[][] board) {
        int fromCol = position.charAt(0) - 'A';
        int fromRow = 8 - Character.getNumericValue(position.charAt(1));
        int toCol = toPosition.charAt(0) - 'A';
        int toRow = 8 - Character.getNumericValue(toPosition.charAt(1));

        // Rook moves only in straight lines (row or column)
        if (fromRow != toRow && fromCol != toCol) return false;

        int rowStep = Integer.compare(toRow, fromRow);
        int colStep = Integer.compare(toCol, fromCol);

        int currentRow = fromRow + rowStep;
        int currentCol = fromCol + colStep;

        // Check for obstructions
        while (currentRow != toRow || currentCol != toCol) {
            if (board[currentRow][currentCol] != null) return false;
            currentRow += rowStep;
            currentCol += colStep;
        }

        // Final square must be empty or contain opponent's piece
        Piece destination = board[toRow][toCol];
        return destination == null || destination.getColor() != this.color;
    }

    /**
     * Moves the Rook to the given position.
     * Updates the internal position string.
     *
     * @param newPosition The new Position object to move the Rook to
     */
    @Override
    public void move(Position newPosition) {
        setPosition(newPosition.toString());
    }

    /**
     * Returns all valid moves for this Rook as strings in standard chess notation.
     * This method accounts for movement in horizontal and vertical directions only,
     * and includes logic to stop at obstructions.
     *
     * @param board The current board represented as a 2D array of Pieces
     * @return An array of strings representing valid destination positions
     */
    @Override
    public String[] possibleMoves(Piece[][] board) {
        ArrayList<String> moves = new ArrayList<>();
        int row = 8 - Character.getNumericValue(position.charAt(1));
        int col = position.charAt(0) - 'A';

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : directions) {
            int r = row + dir[0];
            int c = col + dir[1];
            while (r >= 0 && r < 8 && c >= 0 && c < 8) {
                String toPos = "" + (char) ('A' + c) + (8 - r);
                if (isValidMove(toPos, board)) {
                    moves.add(toPos);
                    if (board[r][c] != null) break;
                } else break;
                r += dir[0];
                c += dir[1];
            }
        }
        return moves.toArray(new String[0]);
    }

    /**
     * Gets all valid moves for the Rook as Position objects.
     * Scans in all four straight directions and stops when blocked by a piece.
     *
     * @param board The current game board instance
     * @return A list of valid Position objects where the Rook can move
     */
    @Override
    public List<Position> getValidMoves(Board.Board board) {
        List<Position> moves = new ArrayList<>();
        int row = 8 - Character.getNumericValue(position.charAt(1));
        int col = position.charAt(0) - 'A';

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : directions) {
            int r = row + dir[0];
            int c = col + dir[1];
            while (r >= 0 && r < 8 && c >= 0 && c < 8) {
                Position toPos = new Position(r, c);
                Piece target = board.getPiece(toPos);
                if (target == null) {
                    moves.add(toPos);
                } else {
                    if (target.getColor() != this.color) {
                        moves.add(toPos);
                    }
                    break;
                }
                r += dir[0];
                c += dir[1];
            }
        }

        return moves;
    }

    /**
     * Returns the string representation of the Rook including its color.
     *
     * @return "wR" for white Rook, "bR" for black Rook
     */
    @Override
    public String toString() {
        return (color == 0 ? "w" : "b") + "R";
    }
}
