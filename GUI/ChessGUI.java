package GUI;

import javax.swing.*;
import java.awt.*;
import Board.Board;
import Utilities.Position;
import Pieces.Piece;
import Pieces.King;

/**
 * ChessGUI sets up the graphical interface for the Chess game,
 * handling board visuals, piece movement, and endgame notification.
 */
public class ChessGUI extends JFrame 
{
    private final JPanel boardPanel = new JPanel(new GridLayout(8, 8));
    private final JButton[][] squares = new JButton[8][8];
    private final Board board = new Board();
    private Position selectedPosition = null;
    private int currentPlayer = 0; // 0 = white, 1 = black

    public ChessGUI() 
    {
        setTitle("Java Chess");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLayout(new BorderLayout());
        add(boardPanel, BorderLayout.CENTER);
        initializeBoard();
        refreshBoard();
        setVisible(true);
    }

    private void initializeBoard() 
    {
        boardPanel.removeAll();
        for (int row = 0; row < 8; row++) 
        {
            for (int col = 0; col < 8; col++) 
            {
                JButton btn = new JButton();
                btn.setOpaque(true);
                btn.setBackground((row + col) % 2 == 0 ? Color.WHITE : Color.GRAY);
                final int r = row, c = col;
                btn.addActionListener(e -> handleClick(r, c));
                squares[row][col] = btn;
                boardPanel.add(btn);
            }
        }
    }

    /**
     * Handles clicks by selecting pieces or attempting a move.
     * Verifies turn-based movement, detects check/checkmate, and updates turns.
     */
    private void handleClick(int row, int col) 
    {
        Position pos = new Position(row, col);
        Piece piece = board.getPiece(pos);

        if (selectedPosition == null) 
        {
            // Only allow selecting your own piece
            if (piece != null && piece.getColor() == currentPlayer) 
            {
                selectedPosition = pos;
                squares[row][col].setBorder(BorderFactory.createLineBorder(Color.RED, 3));
            }
        } 
        else 
        {
            boolean success = board.movePiece(selectedPosition, pos);
            clearSelection();

            if (!success) 
            {
                JOptionPane.showMessageDialog(this, "Invalid move!");
                return;
            }

            refreshBoard();

            // Check for game end by King capture (fallback)
            if (piece instanceof King) 
            {
                JOptionPane.showMessageDialog(this,
                    (currentPlayer == 0 ? "White" : "Black") + " wins by capturing the King!");
                System.exit(0);
            }

            // Check/checkmate logic after successful move
            int opponent = 1 - currentPlayer;
            if (board.isCheckmate(opponent)) 
            {
                JOptionPane.showMessageDialog(this,
                    "Checkmate! " + (currentPlayer == 0 ? "White" : "Black") + " wins!");
                System.exit(0);
            } 
            else if (board.isInCheck(opponent)) 
            {
                JOptionPane.showMessageDialog(this,
                    (opponent == 0 ? "White" : "Black") + " is in check!");
            }

            currentPlayer = opponent;
        }
    }

    private void clearSelection() 
    {
        for (JButton[] row : squares) 
        {
            for (JButton b : row) 
            {
                b.setBorder(null);
            }
        }
        selectedPosition = null;
    }

    private void refreshBoard() 
    {
        for (int row = 0; row < 8; row++) 
        {
            for (int col = 0; col < 8; col++) 
            {
                Piece p = board.getPiece(new Position(row, col));
                squares[row][col].setText(p != null ? p.toString() : "");
            }
        }
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(ChessGUI::new);
    }
}
