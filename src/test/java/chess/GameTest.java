package chess;

import static pieces.Piece.Color.*;
import pieces.*;
import util.StringUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class GameTest {
	private Game game;

	@BeforeEach
	protected void setUp() {
		game = new Game();
	}

	@Test
	public void testInitialize() {
		game.initialize();
		assertEquals(32, game.pieceCount());
		assertEquals(16, Piece.whitePieceCount());
		assertEquals(16, Piece.blackPieceCount());
		String blankRank = StringUtil.appendNewLine("........");
		assertEquals(StringUtil.appendNewLine("RNBQKBNR") + StringUtil.appendNewLine("PPPPPPPP") + blankRank + blankRank
				+ blankRank + blankRank + StringUtil.appendNewLine("pppppppp") + StringUtil.appendNewLine("rnbqkbnr"),
				game.print());
	}

	@Test
	public void testPieceCounts() {
		game.initialize();
		assertEquals(8, game.count(WHITE, Pawn.class));
		assertEquals(8, game.count(BLACK, Pawn.class));
		assertEquals(2, game.count(WHITE, Rook.class));
		assertEquals(2, game.count(BLACK, Rook.class));
		assertEquals(2, game.count(WHITE, Knight.class));
		assertEquals(2, game.count(BLACK, Knight.class));
		assertEquals(2, game.count(WHITE, Bishop.class));
		assertEquals(2, game.count(BLACK, Bishop.class));
		assertEquals(1, game.count(WHITE, Queen.class));
		assertEquals(1, game.count(BLACK, King.class));
	}

	@Test
	public void testPosition() {
		game.initialize();
		BoardTest.assertPiece(BLACK, Knight.class, game.get("b8"));
		BoardTest.assertPiece(WHITE, King.class, game.get("e1"));
	}

	@Test
	public void testStrength() {
		game.put("a7", Piece.createBlackPawn());
		game.put("b6", Piece.createBlackPawn());
		game.put("b8", Piece.createBlackKing());
		game.put("c7", Piece.createBlackPawn());
		game.put("c8", Piece.createBlackRook());
		game.put("d7", Piece.createBlackBishop());
		game.put("e6", Piece.createBlackQueen());
		game.put("e1", Piece.createWhiteRook());
		game.put("f1", Piece.createWhiteKing());
		game.put("f2", Piece.createWhitePawn());
		game.put("f3", Piece.createWhitePawn());
		game.put("f4", Piece.createWhiteKnight());
		game.put("g2", Piece.createWhitePawn());
		game.put("g4", Piece.createWhiteQueen());
		game.put("h3", Piece.createWhitePawn());
		assertEquals(20.0, game.strength(BLACK));
		assertEquals(19.5, game.strength(WHITE));
	}

	@Test
	public void testOrderByStrength() {
		game.put("a1", Piece.createWhiteQueen());
		game.put("a8", Piece.createBlackQueen());
		game.put("a7", Piece.createBlackRook());
		game.put("b2", Piece.createWhitePawn());
		List<Piece> pieces = game.piecesByStrength(BLACK);
		BoardTest.assertPiece(BLACK, Queen.class, pieces.get(0));
		BoardTest.assertPiece(BLACK, Rook.class, pieces.get(1));
		pieces = game.piecesByStrength(WHITE);
		BoardTest.assertPiece(WHITE, Queen.class, pieces.get(0));
		BoardTest.assertPiece(WHITE, Pawn.class, pieces.get(1));
	}

	@Test
	public void testMove() {
		final String square = "d3";
		Piece piece = Piece.createBlackKing();
		game.put(square, piece);
		assertEquals(piece.getPossibleMoves(square, game.getBoard()), game.getPossibleMoves(square));
	}
}