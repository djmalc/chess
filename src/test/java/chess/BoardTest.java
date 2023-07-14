package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import pieces.*;
import pieces.Piece;
import static pieces.Piece.Color.*;
//import static pieces.Piece.Type.*;

public class BoardTest {
	private Board board;

	@BeforeEach
	protected void setUp() {
		board = new Board();
	}

	@Test
	public void testCreate() {
		// spot check the corners
		assertEquals(Piece.noPiece(), board.get("a1"));
		assertEquals(Piece.noPiece(), board.get("a8"));
		assertEquals(Piece.noPiece(), board.get("h1"));
		assertEquals(Piece.noPiece(), board.get("h8"));
	}
	
	@Test
	public void testPlacement() {
		board.put("b6", Piece.createBlackKing());
		board.put("b5", Piece.createBlackRook());
		board.put("c4", Piece.createWhiteKing());
		assertPiece(BLACK, King.class, board.get("b6"));
		assertPiece(BLACK, Rook.class, board.get("b5"));
		assertPiece(WHITE, King.class, board.get("c4"));
	}

	
	public static void assertPiece(Piece.Color color, Class klass, Piece piece) {
		assertEquals(color, piece.getColor());
		assertEquals(klass, piece.getClass());
	}
}