package Pieces;

import Utilities.Position;
import Board.Board;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Knight chess piece, and Knights move in L-shaped patterns.
 * The Knight can move in an 'L' in any direction.
 * This class extends the abstract Piece class.
 */
public class Knight extends Piece {

    /**
     * Constructs a Knight Chess piece, using a given color and coordinate.
     *
     * @param color - 0 for white, 1 for black
     * @param position - Initial position in standard chess notation (e.g., "C1")
     * @return - none
     */
    public Knight(int color, String position) {
        super(color, position);
    }

    /**
     * Determines whether a move is valid for the Knight.
     * The Knight moves in an L-shape: two squares in one direction and then one square perpendicular.
     *
     * @param toPosition - Destination coordinate in chess notation (e.g., "D3")
     * @param board - The current game board represented as a 2D array of Piece objects
     * @return boolean - true if the move is valid, false otherwise
     *
     * 
     */
    @Override
    public boolean isValidMove(String toPosition, Piece[][] board) {
        int fromCol = position.charAt(0) - 'A';
        int fromRow = 8 - Character.getNumericValue(position.charAt(1));
        int toCol = toPosition.charAt(0) - 'A';
        int toRow = 8 - Character.getNumericValue(toPosition.charAt(1));

        int rowDiff = Math.abs(toRow - fromRow);
        int colDiff = Math.abs(toCol - fromCol);

        if ((rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2)) {
            Piece destination = board[toRow][toCol];
            return destination == null || destination.getColor() != this.color;
        }
        return false;
    }

    /**
     * Returns the String that represents the Knight depending on color.
     *
     * @return String - If color == 0 (white), return "wN", "bN" otherwise.
     */
    @Override
    public String toString() {
        return (color == 0 ? "w" : "b") + "N";
    }

    /**
     * Prints the new location that the Knight piece has moved to.
     *
     * @param newPosition - A coordinate of type Position that holds the location of where the Knight moves.
     * @return - none
     */
    @Override
    public void move(Position newPosition) {
        setPosition(newPosition.toString());
    }

    /**
     * Lists the possible moves of a Knight chess piece.
     * Returns an array of valid destination strings in standard notation.
     *
     * @param board - The current board represented as a 2D Piece array
     * @return String[] - An array of valid positions the Knight can move to
     */
    @Override
    public String[] possibleMoves(Piece[][] board) {
        List<String> moves = new ArrayList<>();
        for (Position pos : getValidMoves(new BoardWrapper(board))) {
            moves.add(pos.toString());
        }
        return moves.toArray(new String[0]);
    }

    /**
     * Gets all valid moves for a Knight on a given board.
     * The Knight moves in 8 possible L-shaped directions unless blocked by same-color piece.
     *
     * @param board - An instance of the Board class
     * @return List<Position> - A list of valid Position objects the Knight can legally move to
     */
    @Override
    public List<Position> getValidMoves(Board board) {
        List<Position> validMoves = new ArrayList<>();

        int[][] offsets = {
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
            {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
        };

        int fromCol = position.charAt(0) - 'A';
        int fromRow = 8 - Character.getNumericValue(position.charAt(1));

        for (int[] offset : offsets) {
            int newRow = fromRow + offset[0];
            int newCol = fromCol + offset[1];

            if (newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8) {
                Position newPos = new Position(newRow, newCol);
                Piece target = board.getPiece(newPos);
                if (target == null || target.getColor() != this.color) {
                    validMoves.add(newPos);
                }
            }
        }

        return validMoves;
    }

    /**
     * A helper class to wrap a 2D Piece array as a Board-like interface
     * in order to allow Piece code to compile without modifying Board heavily.
     */
    private static class BoardWrapper extends Board {
        private final Piece[][] wrappedBoard;

        public BoardWrapper(Piece[][] board) {
            super(); // Dummy constructor call
            this.wrappedBoard = board;
        }

        @Override
        public Piece getPiece(Position pos) {
            int row = pos.getRow();
            int col = pos.getColumn();
            if (row >= 0 && row < 8 && col >= 0 && col < 8) {
                return wrappedBoard[row][col];
            }
            return null;
        }
    }
}
