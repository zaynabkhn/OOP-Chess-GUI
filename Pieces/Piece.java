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
     * Will list the possible moves of a chess piece.
     *
     * @param - none
     * @return - none
     */
   abstract void possibleMoves();

   /**
     * Will move the piece to the given position and prints a message.
     *
     * @param newPos - The new position to move the piece to.
     * @return - none
     */
   abstract void move(Position newPos);
}
