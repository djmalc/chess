package pieces;

public class Bishop extends Piece {
	Bishop(Color color) {
		super(color);
	}

	protected char getBaseRepresentation() {
		return 'b';
	}

	@Override
	public double getBaseValue() {
		return 3.0;
	}
}