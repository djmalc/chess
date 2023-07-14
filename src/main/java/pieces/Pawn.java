package pieces;

import chess.Board;
import java.util.List;

public class Pawn extends Piece {
	Pawn(Color color) {
		super(color);
	}

	protected char getBaseRepresentation() {
		return 'p';
	}

	@Override
	protected double getBaseValue() {
		return 1.0;
	}

	@Override
	public void setCurrentStrength(Board board, int rankIndex, int fileIndex) {
		if (otherPawnsInSameFile(board, rankIndex, fileIndex))
			setStrength(0.5);
		else
			setStrength(getBaseValue());
	}

	private boolean otherPawnsInSameFile(Board board, int rankIndex, int fileIndex) {
		int index = 0;
		for (List<Piece> rank : board.ranks()) {
			if (index != rankIndex) {
				Piece piece = rank.get(fileIndex);
				if (piece.getColor().equals(getColor()) && piece.getClass().equals(Pawn.class))
					return true;
			}
			index++;
		}
		return false;
	}
}