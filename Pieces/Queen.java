package Pieces;

import Utilities.Position;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Queen chess piece.
 * The Queen combines the power of a Rook and a Bishop:
 * it can move any number of squares in a straight line — horizontally, vertically, or diagonally.
 * This class extends the abstract Piece class.
 */
public class Queen extends Piece {

    /**
     * Constructs a Queen with a specified color and position.
     *
     * @param color    0 for white, 1 for black
     * @param position The starting position (e.g., "D1")
     */
    public Queen(int color, String position) {
        super(color, position);
    }

    /**
     * Determines if the Queen can move to the specified destination.
     * A valid Queen move is one that would be legal for either a Rook or a Bishop.
     *
     * @param toPosition The destination position in standard chess notation (e.g., "H5")
     * @param board      The current game board represented as a 2D array of Piece objects
     * @return true if the move is valid, false otherwise
     */
    @Override
    public boolean isValidMove(String toPosition, Piece[][] board) {
        Rook rook = new Rook(color, position);
        Bishop bishop = new Bishop(color, position);
        return rook.isValidMove(toPosition, board) || bishop.isValidMove(toPosition, board);
    }

    /**
     * Moves the Queen to the given position.
     * Updates the internal position string.
     *
     * @param newPosition The new Position object to move the Queen to
     */
    @Override
    public void move(Position newPosition) {
        setPosition(newPosition.toString());
    }

    /**
     * Lists all valid moves the Queen can make, using both Rook and Bishop logic.
     * Returns the moves in standard chess notation.
     *
     * @param board The current game board represented as a 2D Piece array
     * @return An array of valid destination positions in string format
     */
    @Override
    public String[] possibleMoves(Piece[][] board) {
        ArrayList<String> moves = new ArrayList<>();

        Rook rook = new Rook(color, position);
        Bishop bishop = new Bishop(color, position);

        for (String move : rook.possibleMoves(board)) moves.add(move);
        for (String move : bishop.possibleMoves(board)) moves.add(move);

        return moves.toArray(new String[0]);
    }

    /**
     * Returns all valid moves the Queen can make as Position objects.
     * Combines the movement logic of both Rook and Bishop.
     *
     * @param board The game board object with access to all pieces
     * @return A list of Position objects representing valid destinations
     */
    @Override
    public List<Position> getValidMoves(Board.Board board) {
        List<Position> moves = new ArrayList<>();
        Rook rook = new Rook(this.color, this.position);
        Bishop bishop = new Bishop(this.color, this.position);
        moves.addAll(rook.getValidMoves(board));
        moves.addAll(bishop.getValidMoves(board));
        return moves;
    }

    /**
     * Returns a string representation of the Queen including its color.
     *
     * @return "wQ" if the Queen is white, "bQ" if the Queen is black
     */
    @Override
    public String toString() {
        return color == 0 ? "\u2655" : "\u265B"; // ♕ or ♛
    }
}
