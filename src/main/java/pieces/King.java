package pieces;

import chess.*;
import java.util.*;

public class King extends Piece {
	King(Color color) {
		super(color);
	}

	protected char getBaseRepresentation() {
		return 'k';
	}

	@Override
	public List<String> getPossibleMoves(String square, Board board) {
		List<String> moves = new ArrayList<String>();
		for (Direction direction : Direction.values())
			if (board.hasNeighbor(square, direction))
				moves.add(board.neighbor(square, direction));
		return moves;
	}
}