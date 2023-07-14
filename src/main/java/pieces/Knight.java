package pieces;

public class Knight extends Piece {
	public Knight(Color color) {
		super(color);
	}

	protected char getBaseRepresentation() {
		return 'n';
	}

	@Override
	public double getBaseValue() {
		return 2.5;
	}
}