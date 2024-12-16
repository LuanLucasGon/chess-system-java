package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

    public Pawn(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "P";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] moveMat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position positionAux = new Position(0,0);

        if (getColor() == Color.WHITE) {
            positionAux.setValues(position.getRow() - 1, position.getColumn());
            if (getBoard().positionExists(positionAux) && !getBoard().thereIsAPiece(positionAux)) {
                moveMat[positionAux.getRow()][positionAux.getColumn()] = true;
            }
            positionAux.setValues(position.getRow() - 2, position.getColumn());
            Position p2 = new Position(position.getRow() - 1, position.getColumn());
            if (getBoard().positionExists(positionAux) && !getBoard().thereIsAPiece(positionAux) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
                moveMat[positionAux.getRow()][positionAux.getColumn()] = true;
            }
            positionAux.setValues(position.getRow() - 1, position.getColumn() - 1);
            if (getBoard().positionExists(positionAux) && isThereOpponentPiece(positionAux)) {
                moveMat[positionAux.getRow()][positionAux.getColumn()] = true;
            }
            positionAux.setValues(position.getRow() - 1, position.getColumn() + 1);
            if (getBoard().positionExists(positionAux) && isThereOpponentPiece(positionAux)) {
                moveMat[positionAux.getRow()][positionAux.getColumn()] = true;
            }
        }
        else {
            positionAux.setValues(position.getRow() + 1, position.getColumn());
            if (getBoard().positionExists(positionAux) && !getBoard().thereIsAPiece(positionAux)) {
                moveMat[positionAux.getRow()][positionAux.getColumn()] = true;
            }
            positionAux.setValues(position.getRow() + 2, position.getColumn());
            Position p2 = new Position(position.getRow() + 1, position.getColumn());
            if (getBoard().positionExists(positionAux) && !getBoard().thereIsAPiece(positionAux) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
                moveMat[positionAux.getRow()][positionAux.getColumn()] = true;
            }
            positionAux.setValues(position.getRow() + 1, position.getColumn() - 1);
            if (getBoard().positionExists(positionAux) && isThereOpponentPiece(positionAux)) {
                moveMat[positionAux.getRow()][positionAux.getColumn()] = true;
            }
            positionAux.setValues(position.getRow() + 1, position.getColumn() + 1);
            if (getBoard().positionExists(positionAux) && isThereOpponentPiece(positionAux)) {
                moveMat[positionAux.getRow()][positionAux.getColumn()] = true;
            }
        }
        return moveMat;
    }
}
