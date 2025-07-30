package Pieces;

import Utilities.Position;
import Board.Board;

import java.util.List;

/**
 * This is the abstract class Piece that works as the base for all pieces in the Chess game.
 * It provides shared fields such as color and position, as well as method signatures that
 * all specific chess piece subclasses must implement.
 */
public abstract class Piece {
    protected int color; // 0 for white, 1 for black
    protected String position;

    /**
     * Constructs a Piece with the given color and starting position.
     *
     * @param color    0 for white, 1 for black
     * @param position The position of the piece in chess notation (e.g., "A1")
     */
    public Piece(int color, String position) {
        this.color = color;
        this.position = position;
    }

    /**
     * Returns the color of this chess piece.
     *
     * @return 0 for white, 1 for black
     */
    public int getColor() {
        return color;
    }

    /**
     * Returns the current position of this piece on the board.
     *
     * @return The position string in standard chess notation (e.g., "E2")
     */
    public String getPosition() {
        return position;
    }

    /**
     * Updates the internal position of this piece.
     *
     * @param newPosition The new position string in standard chess notation (e.g., "E4")
     */
    public void setPosition(String newPosition) {
        this.position = newPosition;
    }

    /**
     * Determines whether a proposed move is valid based on the piece type and the current board state.
     * This method must be implemented by all subclasses to define piece-specific movement rules.
     *
     * @param toPosition The target position in chess notation (e.g., "C3")
     * @param board      The current game board represented as a 2D array of Piece objects
     * @return true if the move is valid, false otherwise
     */
    public abstract boolean isValidMove(String toPosition, Piece[][] board);

    /**
     * Moves the piece to the specified position.
     * This should update the internal position and optionally update any piece-specific state.
     *
     * @param newPosition A Position object representing the new location on the board
     */
    public abstract void move(Position newPosition);

    /**
     * Lists all valid moves for this piece in chess notation (e.g., "D4", "E5").
     * Uses the 2D Piece array format of the board.
     *
     * @param board The current board as a 2D Piece array
     * @return An array of strings representing all valid move destinations
     */
    public abstract String[] possibleMoves(Piece[][] board);

    /**
     * Lists all valid moves for this piece as Position objects.
     * This version interacts with the object-oriented Board class.
     *
     * @param board The current game board instance
     * @return A list of Position objects to which this piece can legally move
     */
    public abstract List<Position> getValidMoves(Board board);

    /**
     * Returns a string representation of the piece including its color.
     * For example, "wP" represents a white pawn and "bR" a black rook.
     *
     * @return A string representing the piece
     */
    public abstract String toString();
}
