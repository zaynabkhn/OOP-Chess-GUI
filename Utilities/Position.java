package Utilities;

/**
 * This is the class Position that arranges the coordinate location for each piece.
 * It is also used to help move a piece to a new location.
 */
public class Position {
    private int row;
    private int column;

    /**
     * Constructs the Position object, using a given row and column to create a coordinate.
     *
     * @param row Row number on the chess board (0 = top)
     * @param column Column number on the chess board (0 = left)
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Constructs a Position object from standard chess notation (e.g., "E2").
     *
     * @param notation Chess notation string indicating the square (letter + number)
     */
    public Position(String notation) {
        this.column = notation.toUpperCase().charAt(0) - 'A';
        this.row = 8 - Character.getNumericValue(notation.charAt(1));
    }

    /**
     * Obtains the row of a coordinate.
     *
     * @return int The row element of a piece, given its position (0 to 7)
     */
    public int getRow() {
        return row;
    }

    /**
     * Obtains the column of a coordinate.
     *
     * @return int The column element of a piece, given its position (0 to 7)
     */
    public int getColumn() {
        return column;
    }

    /**
     * Converts the coordinate of this Position into chess notation.
     *
     * @return String The position in standard chess notation (e.g., "A1")
     */
    @Override
    public String toString() {
        return "" + (char) ('A' + column) + (8 - row);
    }

    /**
     * Checks whether two Position objects represent the same location on the board.
     *
     * @param o Another object to compare
     * @return true if the objects represent the same row and column, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Position))
            return false;
        Position position = (Position) o;
        return row == position.row && column == position.column;
    }

    /**
     * Generates a unique hash code for this Position.
     *
     * @return int The hash code (used for storing in hash-based collections)
     */
    @Override
    public int hashCode() {
        return row * 8 + column;
    }
}
