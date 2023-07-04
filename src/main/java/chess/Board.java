package chess;

import pieces.Pawn;

import java.util.ArrayList;

/**
 * Represents a chess board
 */
public class Board {
    private ArrayList<Pawn> pieces = new ArrayList<Pawn>();
    int pieceCount() {
        return pieces.size();
    }

    void addPiece(Pawn piece) {
        pieces.add(piece);
    }

    ArrayList<Pawn> getPieces() {
        return pieces;
    }
}
