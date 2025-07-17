package Utils;

/**
 * Utility class for position-related conversions and boundary checks.
 */
public class Utils {

    /**
     * Converts a chess notation string (e.g., "A1") to row and column indices.
     *
     * @param pos The chess position string
     * @return An int array with [row, column]
     */
    public static int[] toRowCol(String pos) {
        int col = pos.charAt(0) - 'A';
        int row = 8 - Character.getNumericValue(pos.charAt(1));
        return new int[] { row, col };
    }

    /**
     * Converts row and column indices to standard chess notation (e.g., "A1").
     *
     * @param row Row index (0-7)
     * @param col Column index (0-7)
     * @return Chess position as a string
     */
    public static String toPositionString(int row, int col) {
        char file = (char) ('A' + col);
        int rank = 8 - row;
        return "" + file + rank;
    }

    /**
     * Checks if given row and column indices are within bounds (0 to 7).
     *
     * @param row Row index
     * @param col Column index
     * @return true if within bounds, false otherwise
     */
    public static boolean isInBounds(int row, int col) {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }
}
