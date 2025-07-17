import Board.*;
import Utilities.*;
import java.util.Scanner;

/**
 * Main class to run the Chess game.
 */
public class Main {
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
     * Converts a standard chess notation (e.g., "E2") into a Position object.
     */
    public static Position toPosition(String notation) {
        int col = notation.charAt(0) - 'A';
        int row = 8 - Character.getNumericValue(notation.charAt(1));
        return new Position(row, col);
    }

    /**
     * Checks if the string is a valid chess board position.
     */
    public static boolean isValidPosition(String s) {
        if (s.length() != 2) return false;
        char file = s.charAt(0);
        char rank = s.charAt(1);
        return file >= 'A' && file <= 'H' && rank >= '1' && rank <= '8';
    }
}
