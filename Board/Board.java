package Board;

import Pieces.Piece;
import Pieces.Rook;
import Pieces.Bishop;
import Pieces.Knight;
import Pieces.Queen;
import Pieces.King;
import Pieces.Pawn;
import Utilities.Position;

public class Board {

    private Piece[][] board;

    public Board() {
        board = new Piece[8][8];
        initializeBoard();
    }

    // Initializes the board with all pieces in their standard starting positions.
    
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
            board[1][col] = new Pawn(1, file + "7");
        }

        // Row 6 - White pawns
        for (int col = 0; col < 8; col++) {
            char file = (char) ('A' + col);
            board[6][col] = new Pawn(0, file + "2");
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

    
    // Displays the board in the console with coordinates and pieces.
    
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

    
    // Returns the Piece at the given Position, or null if empty or out of bounds.
    
    public Piece getPiece(Position pos) {
        int row = pos.getRow();
        int col = pos.getColumn();
        if (isInBounds(row, col)) {
            return board[row][col];
        }
        return null;
    }

    
    // Moves a piece from one position to another, if valid.
    
    public void movePiece(Position from, Position to) {
        int fromRow = from.getRow();
        int fromCol = from.getColumn();
        int toRow = to.getRow();
        int toCol = to.getColumn();

        Piece movingPiece = board[fromRow][fromCol];

        if (movingPiece == null) {
            System.out.println("No piece at source position.");
            return;
        }

        if (board[toRow][toCol] != null &&
            board[toRow][toCol].color == movingPiece.color) {
            System.out.println("Cannot capture your own piece.");
            return;
        }

        // Move the piece
        board[toRow][toCol] = movingPiece;
        board[fromRow][fromCol] = null;

        // Update piece's internal position
        movingPiece.position = "" + (char) ('A' + toCol) + (8 - toRow);

        System.out.println("Moved " + movingPiece.getClass().getSimpleName() +
            " to " + movingPiece.position);
    }

    private boolean isInBounds(int row, int col) {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }
}
