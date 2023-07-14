package pieces;

public class Rook extends Piece {
	Rook(Color color) {
		super(color);
	}

	protected char getBaseRepresentation() {
		return 'r';
	}

	@Override
	public double getBaseValue() {
		return 5.0;
	}
}