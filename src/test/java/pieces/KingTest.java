package pieces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import chess.Board;

public class KingTest {
	private Board board;

	@BeforeEach
	protected void setUp() {
		board = new Board();
	}

	@Test
	public void testKingMoveNotOnEdge() {
		Piece piece = Piece.createBlackKing();
		board.put("d3", piece);
		List<String> squares = piece.getPossibleMoves("d3", board);
		assertEquals(8, squares.size());
		assertTrue(squares.contains("c4"));
		assertTrue(squares.contains("d4"));
		assertTrue(squares.contains("e4"));
		assertTrue(squares.contains("c3"));
		assertTrue(squares.contains("e3"));
		assertTrue(squares.contains("c2"));
		assertTrue(squares.contains("d2"));
		assertTrue(squares.contains("e2"));
	}

	@Test
	public void testKingMoveOnBoardEdge() {
		Piece piece = Piece.createBlackKing();
		board.put("a1", piece);
		List<String> squares = piece.getPossibleMoves("a1", board);
		assertEquals(3, squares.size());
		assertTrue(squares.contains("a2"));
		assertTrue(squares.contains("b2"));
		assertTrue(squares.contains("b1"));
	}
}