package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String toString(){
        return "K";
    }

    private boolean canMove(Position position){
        ChessPiece chessPiece = (ChessPiece) getBoard().piece(position);
        return chessPiece == null || chessPiece.getColor() != getColor();
    }

    private boolean testRookCastling(Position position){
        ChessPiece chessPiece = (ChessPiece)getBoard().piece(position);
        return chessPiece != null && chessPiece instanceof Rook && chessPiece.getColor() == getColor() && chessPiece.getMoveCount() == 0;
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

        // #specialmove castling
        if (getMoveCount() == 0 && !chessMatch.getCheck()) {
            // #specialmove castling kingside rook
            Position posT1 = new Position(position.getRow(), position.getColumn() + 3);
            if (testRookCastling(posT1)) {
                Position p1 = new Position(position.getRow(), position.getColumn() + 1);
                Position p2 = new Position(position.getRow(), position.getColumn() + 2);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
                    moveMat[position.getRow()][position.getColumn() + 2] = true;
                }
            }
            // #specialmove castling queenside rook
            Position posT2 = new Position(position.getRow(), position.getColumn() - 4);
            if (testRookCastling(posT2)) {
                Position p1 = new Position(position.getRow(), position.getColumn() - 1);
                Position p2 = new Position(position.getRow(), position.getColumn() - 2);
                Position p3 = new Position(position.getRow(), position.getColumn() - 3);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
                    moveMat[position.getRow()][position.getColumn() - 2] = true;
                }
            }
        }

        return moveMat;
    }
}
