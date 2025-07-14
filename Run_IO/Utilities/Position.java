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
   
   /*
   public Position(String coordinate)
   {
      //Set row and column based on the String.
   }
   
   
   public String toNotation()
   {
      //May not be necessary.
   }
   */
   
   
   public int getRow()
   {
      return row;
   }
   
   public int getColumn()
   {
      return column;
   }
}