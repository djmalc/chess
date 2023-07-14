package pieces;

public class NoPiece extends Piece {
	public NoPiece() {
		super(Color.WHITE);
	}

	protected char getBaseRepresentation() {
		return '.';
	}
}