package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "K";
    }

    private boolean canMove(Position position){
        ChessPiece chessPiece = (ChessPiece) getBoard().piece(position);
        return chessPiece == null || chessPiece.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] moveMat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position positionAux = new Position(0,0);

        //above
        positionAux.setValues(position.getRow() - 1, position.getColumn());
        if(getBoard().positionExists(positionAux) && canMove(positionAux)){
            moveMat[positionAux.getRow()][positionAux.getColumn()] = true;
        }

        //below
        positionAux.setValues(position.getRow() + 1, position.getColumn());
        if(getBoard().positionExists(positionAux) && canMove(positionAux)){
            moveMat[positionAux.getRow()][positionAux.getColumn()] = true;
        }

        //left
        positionAux.setValues(position.getRow(), position.getColumn() - 1);
        if(getBoard().positionExists(positionAux) && canMove(positionAux)){
            moveMat[positionAux.getRow()][positionAux.getColumn()] = true;
        }

        //left
        positionAux.setValues(position.getRow(), position.getColumn() + 1);
        if(getBoard().positionExists(positionAux) && canMove(positionAux)){
            moveMat[positionAux.getRow()][positionAux.getColumn()] = true;
        }

        //nw
        positionAux.setValues(position.getRow() - 1, position.getColumn() - 1);
        if(getBoard().positionExists(positionAux) && canMove(positionAux)){
            moveMat[positionAux.getRow()][positionAux.getColumn()] = true;
        }

        //ne
        positionAux.setValues(position.getRow() - 1, position.getColumn() + 1);
        if(getBoard().positionExists(positionAux) && canMove(positionAux)){
            moveMat[positionAux.getRow()][positionAux.getColumn()] = true;
        }

        //sw
        positionAux.setValues(position.getRow() + 1, position.getColumn() - 1);
        if(getBoard().positionExists(positionAux) && canMove(positionAux)){
            moveMat[positionAux.getRow()][positionAux.getColumn()] = true;
        }

        //se
        positionAux.setValues(position.getRow() + 1, position.getColumn() + 1);
        if(getBoard().positionExists(positionAux) && canMove(positionAux)){
            moveMat[positionAux.getRow()][positionAux.getColumn()] = true;
        }

        return moveMat;
    }
}
