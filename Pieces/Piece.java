package Pieces;

import Utilities.Position;

/**
 * This is the abstract class Piece that works as the base for all pieces in the Chess game.
 */
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
