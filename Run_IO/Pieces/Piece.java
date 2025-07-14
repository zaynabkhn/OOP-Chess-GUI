package Pieces;

import Utilities.Position;

public abstract class Piece
{
   int color;
   String position;
   
   abstract void possibleMoves();
   
   abstract void move(Position newPos);
}