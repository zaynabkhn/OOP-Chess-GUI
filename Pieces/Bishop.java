package Pieces;

import Utilities.Position;
import Board.Board;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Bishop chess piece.
 * The Bishop moves diagonally in all directions and can continue until blocked.
 * This class extends the abstract Piece class.
 */
public class Bishop extends Piece {

    /**
     * Constructs a Bishop with a specified color and initial position.
     *
     * @param color - 0 for white, 1 for black
     * @param position - Initial position in standard chess notation (e.g., "C1")
     * @return - none
     */
    public Bishop(int color, String position) {
        super(color, position);
    }

    /**
     * Checks whether the move to a given position is valid for a Bishop.
     * Valid Bishop moves must be diagonal and unobstructed.
     *
     * @param toPosition - Destination square in standard notation (e.g., "F4")
     * @param board - 2D array representing the current board state
     * @return - true if the move is valid, false otherwise
     */
    @Override
    public boolean isValidMove(String toPosition, Piece[][] board) {
        int fromCol = position.charAt(0) - 'A';
        int fromRow = 8 - Character.getNumericValue(position.charAt(1));
        int toCol = toPosition.charAt(0) - 'A';
        int toRow = 8 - Character.getNumericValue(toPosition.charAt(1));

        int rowDiff = Math.abs(toRow - fromRow);
        int colDiff = Math.abs(toCol - fromCol);

        if (rowDiff != colDiff || rowDiff == 0) return false;

        int rowStep = Integer.compare(toRow, fromRow);
        int colStep = Integer.compare(toCol, fromCol);

        int r = fromRow + rowStep;
        int c = fromCol + colStep;

        // Check for obstructions between from and to squares
        while (r != toRow && c != toCol) {
            if (board[r][c] != null) return false;
            r += rowStep;
            c += colStep;
        }

        Piece destination = board[toRow][toCol];
        return destination == null || destination.getColor() != this.color;
    }

    /**
     * Moves the Bishop to the given position.
     *
     * @param newPosition - The new position to move the Bishop to
     * @return - none
     */
    @Override
    public void move(Position newPosition) {
        setPosition(newPosition.toString());
    }

    /**
     * Returns all possible legal destination squares for the Bishop based on the current board.
     *
     * @param board - 2D array representing the current board state
     * @return - An array of Strings representing all possible destination squares
     */
    @Override
    public String[] possibleMoves(Piece[][] board) {
        ArrayList<String> moves = new ArrayList<>();
        for (Position pos : getValidMoves(new BoardWrapper(board))) {
            moves.add(pos.toString());
        }
        return moves.toArray(new String[0]);
    }

    /**
     * Returns a list of all valid Position objects the Bishop can move to.
     * This uses full board logic and accounts for obstructions and capture rules.
     *
     * @param board - The current Board instance
     * @return - A list of valid Position objects for this Bishop
     */
    @Override
    public List<Position> getValidMoves(Board board) {
        List<Position> moves = new ArrayList<>();
        Position current = new Position(position);
        int row = current.getRow();
        int col = current.getColumn();

        int[][] directions = {{1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        for (int[] d : directions) {
            int r = row + d[0], c = col + d[1];
            while (r >= 0 && r < 8 && c >= 0 && c < 8) {
                Position toPos = new Position(r, c);
                Piece target = board.getPiece(toPos);
                if (target == null) {
                    moves.add(toPos);
                } else {
                    if (target.getColor() != this.color) {
                        moves.add(toPos);
                    }
                    break; // Stop scanning if piece is in the way
                }
                r += d[0];
                c += d[1];
            }
        }

        return moves;
    }

    /**
     * Provides a wrapper to adapt a Piece[][] array into a Board interface.
     * Used for compatibility with the getValidMoves method.
     */
    private static class BoardWrapper extends Board {
        private final Piece[][] wrappedBoard;

        /**
         * Constructs a wrapper board from a 2D Piece array.
         *
         * @param board - The current board state
         * @return - none
         */
        public BoardWrapper(Piece[][] board) {
            super(); // dummy base class call
            this.wrappedBoard = board;
        }

        /**
         * Gets the piece at a given position on the wrapped board.
         *
         * @param pos - Position to query
         * @return - Piece at the given position, or null if empty
         */
        @Override
        public Piece getPiece(Position pos) {
            int r = pos.getRow();
            int c = pos.getColumn();
            if (r >= 0 && r < 8 && c >= 0 && c < 8) {
                return wrappedBoard[r][c];
            }
            return null;
        }
    }

    /**
     * Returns the character representation of the Bishop for display on the board.
     *
     * @param - none
     * @return - "wB" for white bishop, "bB" for black bishop
     */
    @Override
    public String toString() {
        return (color == 0 ? "w" : "b") + "B";
    }
}
