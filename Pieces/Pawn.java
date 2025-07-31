package Pieces;

import Utilities.Position;
import Board.Board;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Pawn chess piece.
 * Pawns move forward and capture diagonally. On their first move, they may advance two squares.
 * This class extends the abstract Piece class.
 */
public class Pawn extends Piece {

    private boolean hasMoved;

    /**
     * Constructs a Pawn with a specified color and position.
     *
     * @param color    0 for white, 1 for black
     * @param position The starting position (e.g., "E2")
     */
    public Pawn(int color, String position) {
        super(color, position);
        hasMoved = false;
    }

    /**
     * Checks if a move is valid for the Pawn.
     * A valid move includes:
     * - Moving forward 1 square if unblocked
     * - Moving forward 2 squares from the starting position if both squares are unblocked
     * - Capturing diagonally if an opponent's piece occupies the target square
     *
     * @param toPosition The target position in standard notation (e.g., "E4")
     * @param board      The current state of the chess board
     * @return true if the move is valid, false otherwise
     */
    @Override
    public boolean isValidMove(String toPosition, Piece[][] board) {
        int fromCol = position.charAt(0) - 'A';
        int fromRow = 8 - Character.getNumericValue(position.charAt(1));
        int toCol = toPosition.charAt(0) - 'A';
        int toRow = 8 - Character.getNumericValue(toPosition.charAt(1));

        int direction = (color == 0) ? -1 : 1; // White moves up, Black moves down
        int rowDiff = toRow - fromRow;
        int colDiff = Math.abs(toCol - fromCol);

        // Forward move
        if (colDiff == 0) {
            // Move one square
            if (rowDiff == direction && board[toRow][toCol] == null) {
                return true;
            }

            // Move two squares from initial position
            if (!hasMoved && rowDiff == 2 * direction
                    && board[fromRow + direction][fromCol] == null
                    && board[toRow][toCol] == null) {
                return true;
            }
        }

        // Diagonal capture
        if (colDiff == 1 && rowDiff == direction) {
            Piece target = board[toRow][toCol];
            return target != null && target.getColor() != this.color;
        }

        return false;
    }

    /**
     * Moves the Pawn to the given position and marks it as having moved.
     *
     * @param newPosition The new position to move the Pawn to.
     */
    @Override
    public void move(Position newPosition) {
        setPosition(newPosition.toString());
        hasMoved = true;
    }

    /**
     * Returns all valid destination strings for the Pawn from its current position.
     * Useful for GUI display or move generation.
     *
     * @param board The current state of the board as a 2D array of Pieces
     * @return An array of strings representing valid destination positions
     */
    @Override
    public String[] possibleMoves(Piece[][] board) {
        ArrayList<String> moves = new ArrayList<>();
        for (Position p : getValidMoves(new BoardAdapter(board))) {
            moves.add(p.toString());
        }
        return moves.toArray(new String[0]);
    }

    /**
     * Returns a list of valid Position objects where the Pawn can move.
     * This method uses the updated Board interface to check legality of all potential moves.
     *
     * @param board The game board providing access to pieces by position
     * @return A list of valid Position objects
     */
    @Override
    public List<Position> getValidMoves(Board board) {
        List<Position> moves = new ArrayList<>();
        Position current = new Position(position);
        int row = current.getRow();
        int col = current.getColumn();

        int direction = (color == 0) ? -1 : 1;
        int nextRow = row + direction;

        // One square forward
        Position oneStep = new Position(nextRow, col);
        if (board.getPiece(oneStep) == null) {
            moves.add(oneStep);

            // Two squares forward from starting position
            int startRow = (color == 0) ? 6 : 1;
            Position twoSteps = new Position(row + 2 * direction, col);
            if (row == startRow && board.getPiece(twoSteps) == null
                    && board.getPiece(oneStep) == null) {
                moves.add(twoSteps);
            }
        }

        // Diagonal captures
        for (int dc = -1; dc <= 1; dc += 2) {
            int newCol = col + dc;
            if (newCol >= 0 && newCol < 8 && nextRow >= 0 && nextRow < 8) {
                Position diag = new Position(nextRow, newCol);
                Piece target = board.getPiece(diag);
                if (target != null && target.getColor() != this.color) {
                    moves.add(diag);
                }
            }
        }

        return moves;
    }

    /**
     * Returns a string representation of the Pawn.
     *
     * @return "wP" for white pawns, "bP" for black pawns
     */
    @Override
    public String toString() {
        return color == 0 ? "\u2659" : "\u265F"; // ♙ or ♟
    }

    /**
     * Internal adapter class that wraps a legacy 2D Piece array as a Board instance.
     * Allows compatibility with Board-dependent methods without refactoring legacy code.
     */
    private static class BoardAdapter extends Board {
        private final Piece[][] legacyBoard;

        /**
         * Constructs a new BoardAdapter from an existing Piece array.
         *
         * @param board 2D array representing the current board state
         */
        public BoardAdapter(Piece[][] board) {
            super();
            this.legacyBoard = board;
        }

        /**
         * Retrieves the piece at a given position.
         *
         * @param pos Position on the board
         * @return The piece at that position, or null if none exists or out of bounds
         */
        @Override
        public Piece getPiece(Position pos) {
            int r = pos.getRow();
            int c = pos.getColumn();
            return (r >= 0 && r < 8 && c >= 0 && c < 8) ? legacyBoard[r][c] : null;
        }
    }
}
