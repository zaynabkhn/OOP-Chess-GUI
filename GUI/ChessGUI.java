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
public class ChessGUI extends JFrame 
{
    private final JPanel boardPanel = new JPanel(new GridLayout(8, 8));
    private final JButton[][] squares = new JButton[8][8];
    private final Board board = new Board();
    private Position selectedPosition = null;

    /**
     * Constructs a GUI for the Chess game.
     *
     * @param - none
     * @return - none
     */
    public ChessGUI() 
    {
        setTitle("Java Chess");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        add(boardPanel);
        initializeBoard();
        refreshBoard();
        setVisible(true);
    }

    /**
     * Initializes the GUI board with buttons to make the board interactible.
     *
     * @param - none
     * @return - none
     */
    private void initializeBoard() 
    {
        boardPanel.removeAll();
        for (int row = 0; row < 8; row++) 
        {
            for (int col = 0; col < 8; col++) 
            {
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

    /**
     * Operates instructions for play depending on if a selected position has a piece on it or not.
     *
     * @param row - Gives an int that tells what row the selection is on.
     * @param col - Gives an int that tells what row the selection is on.
     * @return - none
     */
    private void handleClick(int row, int col) 
    {
        Position pos = new Position(row, col);
        Piece piece = board.getPiece(pos);
        if (selectedPosition == null) 
        {
            if (piece != null) 
            {
                selectedPosition = pos;
                squares[row][col].setBorder(BorderFactory.createLineBorder(Color.RED, 3));
            }
        } 
        else 
        {
            Piece moving = board.getPiece(selectedPosition);
            Piece target = board.getPiece(pos);
            board.movePiece(selectedPosition, pos);
            refreshBoard();
            if (target instanceof Pieces.King) 
            {
                JOptionPane.showMessageDialog(this,
                    (moving.getColor() == 0 ? "White" : "Black") + " wins by capturing the King!");
                System.exit(0);
            }
            clearSelection();
        }
    }

    /**
     * Clears any selected buttons to longer have a selection indicator.
     *
     * @param - none
     * @return - none
     */
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

    /**
     * This sets the board to the newest state after it is called.
     *
     * @param - none
     * @return - none
     */
    private void refreshBoard() 
    {
        for (int row=0; row<8; row++) for (int col=0; col<8; col++) 
        {
            Piece p = board.getPiece(new Position(row, col));
            squares[row][col].setText(p != null ? p.toString() : "");
        }
    }

    /**
     * Instantiates that a new GUI will be set for later use.
     *
     * @param String[] args - Gives String arguments to use Swing utilities later.
     * @return - none
     */
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(ChessGUI::new);
    }
}
