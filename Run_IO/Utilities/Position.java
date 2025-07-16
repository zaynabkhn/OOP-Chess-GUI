package Utilities;

/**
 * This is the class Position that arranges the coordinate location for each piece.
 * It is also used to help move a piece to a new location.
 */
public class Position
{
   private final int row;
   private final int column;

   /**
     * Constructs the Position object, using a given row and column to create a coordinate.
     *
     * @param r - Row number (int)
     * @param position - Column number (int)
     * @return - none
     */
   public Position(int r, int c)
   {
      this.row = r;
      this.column = c;
   } 

   /**
     * Obtains the row of a coordinate.
     *
     * @param - none
     * @return int - The row elemnt of a piece, given its position.
     */
   public int getRow()
   {
      return row;
   }

   /**
     * Obtains the column of a coordinate.
     *
     * @param - none
     * @return int - The column elemnt of a piece, given its position.
     */
   public int getColumn()
   {
      return column;
   }
}
