package pieces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import chess.Board;

public class QueenTest {
	private Board board;

	@BeforeEach
	protected void setUp() {
		board = new Board();
	}

	@Test
	public void testQueenMove() {
		Piece piece = Piece.createBlackQueen();
		board.put("a1", piece);
		List<String> moves = piece.getPossibleMoves("a1", board);
		assertEquals(21, moves.size());
		assertTrue(moves.contains("a2"));
		assertTrue(moves.contains("a3"));
		assertTrue(moves.contains("a4"));
		assertTrue(moves.contains("a5"));
		assertTrue(moves.contains("a6"));
		assertTrue(moves.contains("a7"));
		assertTrue(moves.contains("a8"));
		assertTrue(moves.contains("b1"));
		assertTrue(moves.contains("c1"));
		assertTrue(moves.contains("d1"));
		assertTrue(moves.contains("e1"));
		assertTrue(moves.contains("f1"));
		assertTrue(moves.contains("g1"));
		assertTrue(moves.contains("h1"));
		assertTrue(moves.contains("b2"));
		assertTrue(moves.contains("c3"));
		assertTrue(moves.contains("d4"));
		assertTrue(moves.contains("e5"));
		assertTrue(moves.contains("f6"));
		assertTrue(moves.contains("g7"));
		assertTrue(moves.contains("h8"));
	}
}