package Pieces;

import Utilities.Position;

public abstract class Piece
{
   int color;
   String position;

   /**
     * Lists the possible moves of a chess piece.
     *
     * @param - none
     * @return - none
     */
   abstract void possibleMoves();
   
   abstract void move(Position newPos);
}
