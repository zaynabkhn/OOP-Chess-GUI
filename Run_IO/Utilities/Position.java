package Utilities;

public class Position
{
   private final int row;
   private final int column;
   
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
