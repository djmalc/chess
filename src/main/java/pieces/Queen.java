package pieces;

import chess.*;
import java.util.*;

public class Queen extends Piece {
	Queen(Color color) {
		super(color);
	}

	protected char getBaseRepresentation() {
		return 'q';
	}

	@Override
	public double getBaseValue() {
		return 9.0;
	}

	@Override
	public List<String> getPossibleMoves(String square, Board board) {
		List<String> moves = new ArrayList<String>();
		for (Direction direction : Direction.values())
			gatherToEdge(moves, board, square, direction);
		return moves;
	}

	protected void gatherToEdge(List<String> moves, Board board, String square, Direction direction) {
		if (board.hasNeighbor(square, direction)) {
			String neighbor = board.neighbor(square, direction);
			moves.add(neighbor);
			gatherToEdge(moves, board, neighbor, direction);
		}
	}
}