import Board.Board;
import Utilities.Position;
import java.util.Scanner;

/**
 * Main class to run the Console Chess game.
 * This class handles user input, board display, and turn-based gameplay.
 */
public class Main {

    /**
     * The entry point of the Chess game.
     * Initializes the game board, displays it, and handles user input in a loop.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();

        System.out.println("Welcome to Console Chess!");
        board.display();

        while (true) {
            System.out.print("\nEnter your move (e.g., E2 E4), or type 'exit' to quit: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting game. Goodbye!");
                break;
            }

            String[] parts = input.split(" ");
            if (parts.length != 2) {
                System.out.println("Invalid input. Please use the format 'E2 E4'.");
                continue;
            }

            String from = parts[0].toUpperCase();
            String to = parts[1].toUpperCase();

            if (!isValidPosition(from) || !isValidPosition(to)) {
                System.out.println("Invalid positions. Use format like 'A2', 'H7', etc.");
                continue;
            }

            Position fromPos = toPosition(from);
            Position toPos = toPosition(to);

            board.movePiece(fromPos, toPos);
            board.display();
        }

        scanner.close();
    }

    /**
     * Converts a standard chess notation string (e.g., "E2") to a Position object.
     *
     * @param notation The chess notation string.
     * @return A Position object representing the row and column on the board.
     */
    public static Position toPosition(String notation) {
        int col = notation.charAt(0) - 'A';
        int row = 8 - Character.getNumericValue(notation.charAt(1));
        return new Position(row, col);
    }

    /**
     * Validates if a given string represents a valid chess board position.
     *
     * @param s The string to validate (e.g., "A2", "H8").
     * @return true if the string is a valid position, false otherwise.
     */
    public static boolean isValidPosition(String s) {
        if (s.length() != 2) return false;
        char file = s.charAt(0);
        char rank = s.charAt(1);
        return file >= 'A' && file <= 'H' && rank >= '1' && rank <= '8';
    }
}
