package Pieces;

public abstract class Piece
{
   int color;
   String position;
   
   abstract void possibleMoves();
   
   //Have Arg. be Position newPos
   abstract void move();
}