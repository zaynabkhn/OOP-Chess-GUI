package Board;

import Pieces.*;
import Utilities.Position;

/**
 * The class Board creates everything necessary for setting up the Chess board.
 */
public class Board {

    private Piece[][] board;

    public Board() {
        board = new Piece[8][8];
        initializeBoard();
    }

    /**
     * Initializes the board with all pieces in their standard starting positions.
     *
     * @param - none
     * @return - none
     */
    private void initializeBoard() {
        // Row 0 - Black major pieces
        board[0][0] = new Rook(1, "A8");
        board[0][1] = new Knight(1, "B8");
        board[0][2] = new Bishop(1, "C8");
        board[0][3] = new Queen(1, "D8");
        board[0][4] = new King(1, "E8");
        board[0][5] = new Bishop(1, "F8");
        board[0][6] = new Knight(1, "G8");
        board[0][7] = new Rook(1, "H8");

        // Row 1 - Black pawns
        for (int col = 0; col < 8; col++) {
            char file = (char) ('A' + col);
            board[1][col] = new Pawn(1, file + "7"); // ZAINAB: Added black pawns initialization
        }

        // Row 6 - White pawns
        for (int col = 0; col < 8; col++) {
            char file = (char) ('A' + col);
            board[6][col] = new Pawn(0, file + "2"); // ZAINAB: Added white pawns initialization
        }

        // Row 7 - White major pieces
        board[7][0] = new Rook(0, "A1");
        board[7][1] = new Knight(0, "B1");
        board[7][2] = new Bishop(0, "C1");
        board[7][3] = new Queen(0, "D1");
        board[7][4] = new King(0, "E1");
        board[7][5] = new Bishop(0, "F1");
        board[7][6] = new Knight(0, "G1");
        board[7][7] = new Rook(0, "H1");
    }

    /**
     * Displays the board in the console with coordinates and pieces.
     *
     * @param - none
     * @return - none
     */
    public void display() {
        System.out.println("    A   B   C   D   E   F   G   H");
        System.out.println("  +---+---+---+---+---+---+---+---+");

        for (int row = 0; row < 8; row++) {
            System.out.print((8 - row) + " |");

            for (int col = 0; col < 8; col++) {
                Piece piece = board[row][col];
                if (piece == null) {
                    System.out.print("   |");
                } else {
                    String symbol = piece.toString();
                    System.out.print(" " + symbol + " |");
                }
            }

            System.out.println(" " + (8 - row));
            System.out.println("  +---+---+---+---+---+---+---+---+");
        }

        System.out.println("    A   B   C   D   E   F   G   H");
    }

    /**
     * Returns the Piece at the given Position, or null if empty or out of bounds.
     *
     * @param pos - An object of type Position that contains a coordinate to identify a piece at that coordinate, if it exists and is in bounds.
     * @return board[row][col] if the coordinate given by pos is in bounds. Return null, otherwise.
     */
    public Piece getPiece(Position pos) {
        int row = pos.getRow();
        int col = pos.getColumn();
        if (isInBounds(row, col)) {
            return board[row][col];
        }
        return null;
    }

    /**
     * Moves a piece from one position to another, if valid.
     *
     * @param from - Object of type Position that gives the coordinate of the starting position of a piece.
     * @param to - Object of type Position that gives the coordinate of the end position of a piece.
     * @return true if the move was successful, false otherwise
     */
    public boolean movePiece(Position from, Position to) {
        Piece moving = getPiece(from);
        if (moving == null) {
            System.out.println("No piece at source position.");
            return false;
        }

        Piece target = getPiece(to);
        if (target != null && target.getColor() == moving.getColor()) {
            System.out.println("Cannot capture your own piece.");
            return false;
        }

        for (Position pos : moving.getValidMoves(this)) {
            if (pos.equals(to)) {
                board[to.getRow()][to.getColumn()] = moving;
                board[from.getRow()][from.getColumn()] = null;
                moving.setPosition(to.toString());
                System.out.println("Moved " + moving.getClass().getSimpleName() + " to " + moving.getPosition());
                return true;
            }
        }

        System.out.println("Invalid move for " + moving.getClass().getSimpleName());
        return false;
    }

    /**
     * Checks if a piece is in bounds, given coordinates.
     *
     * @param row - A primitive of type int that gives the row portion of the coordinate.
     * @param col - A primitive of type int that gives the column portion of the coordinate.
     * @return boolean
     */
    private boolean isInBounds(int row, int col) {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }

    /**
     * Checks if the king of the given color is currently in check.
     *
     * @param color - A primitive of type int (0 for white, 1 for black)
     * @return true if the king is in check, false otherwise
     */
    public boolean isInCheck(int color) {
        Position kingPos = findKing(color);
        if (kingPos == null) return false;

        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                Piece p = board[r][c];
                if (p != null && p.getColor() != color) {
                    for (Position move : p.getValidMoves(this)) {
                        if (move.equals(kingPos)) return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Determines if the player is in checkmate.
     *
     * @param color - A primitive of type int that represents the color (0 for white, 1 for black)
     * @return true if the player's king is in checkmate, false otherwise
     */
    public boolean isCheckmate(int color) {
        if (!isInCheck(color)) return false;

        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                Position from = new Position(r, c);
                Piece p = getPiece(from);
                if (p == null || p.getColor() != color) continue;

                for (Position to : p.getValidMoves(this)) {
                    Piece captured = board[to.getRow()][to.getColumn()];

                    board[to.getRow()][to.getColumn()] = p;
                    board[r][c] = null;
                    String originalPos = p.getPosition();
                    p.setPosition(to.toString());

                    boolean stillInCheck = isInCheck(color);

                    board[r][c] = p;
                    board[to.getRow()][to.getColumn()] = captured;
                    p.setPosition(originalPos);

                    if (!stillInCheck) return false;
                }
            }
        }

        return true;
    }

    /**
     * Finds the position of the king for the specified color.
     *
     * @param color - A primitive of type int (0 for white, 1 for black)
     * @return a Position object indicating the king’s location or null if not found
     */
    private Position findKing(int color) {
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                Piece p = board[r][c];
                if (p instanceof King && p.getColor() == color) {
                    return new Position(r, c);
                }
            }
        }
        return null;
    }
}
