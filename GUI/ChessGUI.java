package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Board.Board;
import Utilities.Position;
import Pieces.Piece;

/**
 * ChessGUI sets up the graphical interface for the Chess game,
 * handling board visuals, piece movement, and endgame notification.
 */
public class ChessGUI extends JFrame {
    private final JPanel boardPanel = new JPanel(new GridLayout(8, 8));
    private final JButton[][] squares = new JButton[8][8];
    private final Board board = new Board();
    private Position selectedPosition = null;

    public ChessGUI() {
        setTitle("Java Chess");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        add(boardPanel);
        initializeBoard();
        refreshBoard();
        setVisible(true);
    }

    private void initializeBoard() {
        boardPanel.removeAll();
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                JButton btn = new JButton();
                btn.setOpaque(true);
                btn.setBackground((row + col) % 2 == 0 ? Color.LIGHT_GRAY : Color.DARK_GRAY);
                final int r = row, c = col;
                btn.addActionListener(e -> handleClick(r, c));
                squares[row][col] = btn;
                boardPanel.add(btn);
            }
        }
    }

    private void handleClick(int row, int col) {
        Position pos = new Position(row, col);
        Piece piece = board.getPiece(pos);
        if (selectedPosition == null) {
            if (piece != null) {
                selectedPosition = pos;
                squares[row][col].setBorder(BorderFactory.createLineBorder(Color.RED, 3));
            }
        } else {
            Piece moving = board.getPiece(selectedPosition);
            Piece target = board.getPiece(pos);
            board.movePiece(selectedPosition, pos);
            refreshBoard();
            if (target instanceof Pieces.King) {
                JOptionPane.showMessageDialog(this,
                    (moving.getColor() == 0 ? "White" : "Black") + " wins by capturing the King!");
                System.exit(0);
            }
            clearSelection();
        }
    }

    private void clearSelection() {
    for (JButton[] row : squares) {
        for (JButton b : row) {
            b.setBorder(null);
        }
    }
    selectedPosition = null;
}


    private void refreshBoard() {
        for (int row=0; row<8; row++) for (int col=0; col<8; col++) {
            Piece p = board.getPiece(new Position(row, col));
            squares[row][col].setText(p != null ? p.toString() : "");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ChessGUI::new);
    }
}
