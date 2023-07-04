package chess;

import pieces.Pawn;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class BoardTest {
    @Test
    public void testCreate() {
        Board board = new Board();
        Pawn whitePawn = new Pawn(Pawn.WHITE);
        board.addPiece(whitePawn);
        assertEquals(1, board.pieceCount());
        ArrayList<Pawn> pieces = board.getPieces();

        assertEquals(pieces.get(0), whitePawn);

        Pawn blackPawn = new Pawn(Pawn.BLACK);
        board.addPiece(blackPawn);
        assertEquals(2, board.pieceCount());

        assertEquals(whitePawn, pieces.get(0));
        assertEquals(blackPawn, pieces.get(1));

    }
}
