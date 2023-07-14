package pieces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PieceTest {
	
	@Test
	public void testCreate() {
		verifyCreation(Piece.createWhitePawn(), Piece.createBlackPawn(), Pawn.class);
		verifyCreation(Piece.createWhiteRook(), Piece.createBlackRook(), Rook.class);
		verifyCreation(Piece.createWhiteKnight(), Piece.createBlackKnight(), Knight.class);
		verifyCreation(Piece.createWhiteBishop(), Piece.createBlackBishop(), Bishop.class);
		verifyCreation(Piece.createWhiteQueen(), Piece.createBlackQueen(), Queen.class);
		verifyCreation(Piece.createWhiteKing(), Piece.createBlackKing(), King.class);
		Piece blank = Piece.noPiece();
		assertEquals('.', blank.getRepresentation());
	}

	private void verifyCreation(Piece whitePiece, Piece blackPiece, Class klass) {
		assertTrue(whitePiece.isWhite());
		assertEquals(klass, whitePiece.getClass());
		assertTrue(blackPiece.isBlack());
		assertEquals(klass, blackPiece.getClass());
		assertEquals(Character.toUpperCase(whitePiece.getRepresentation()), blackPiece.getRepresentation());
	}

	@Test
	public void testColorCounts() {
		Piece.resetCounts();
		// b, w
		assertCounts(0, 0);
		Piece.createBlackBishop();
		assertCounts(1, 0);
		Piece.createBlackQueen();
		assertCounts(2, 0);
		Piece.createWhiteKing();
		assertCounts(2, 1);
		Piece.createBlackRook();
		assertCounts(3, 1);
		Piece.createWhitePawn();
		assertCounts(3, 2);
		Piece.createWhitePawn();
		assertCounts(3, 3);
		Piece.createBlackKnight();
		assertCounts(4, 3);
		// ...
	}

	private void assertCounts(int blackCount, int whiteCount) {
		assertEquals(blackCount, Piece.blackPieceCount());
		assertEquals(whiteCount, Piece.whitePieceCount());
	}
}