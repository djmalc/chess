package pieces;

import chess.*;
import java.util.*;

public abstract class Piece implements Comparable<Piece> {
	public enum Color {
		WHITE, BLACK
	};

	public static final Piece noPiece = new NoPiece();
	private static int whitePieceCount = 0;
	private static int blackPieceCount = 0;
	private Color color;
	private double strength;

	public static Piece createWhitePawn() {
		return new Pawn(Color.WHITE);
	}

	public static Piece createBlackPawn() {
		return new Pawn(Color.BLACK);
	}

	public static Piece createWhiteRook() {
		return new Rook(Color.WHITE);
	}

	public static Piece createBlackRook() {
		return new Rook(Color.BLACK);
	}

	public static Piece createWhiteKnight() {
		return new Knight(Color.WHITE);
	}

	public static Piece createBlackKnight() {
		return new Knight(Color.BLACK);
	}

	public static Piece createWhiteBishop() {
		return new Bishop(Color.WHITE);
	}

	public static Piece createBlackBishop() {
		return new Bishop(Color.BLACK);
	}

	public static Piece createWhiteQueen() {
		return new Queen(Color.WHITE);
	}

	public static Piece createBlackQueen() {
		return new Queen(Color.BLACK);
	}

	public static Piece createWhiteKing() {
		return new King(Color.WHITE);
	}

	public static Piece createBlackKing() {
		return new King(Color.BLACK);
	}

	public static Piece noPiece() {
		return noPiece;
	}

	private static void incrementWhite() {
		whitePieceCount++;
	}

	private static void incrementBlack() {
		blackPieceCount++;
	}

	public static int whitePieceCount() {
		return whitePieceCount;
	}

	public static int blackPieceCount() {
		return blackPieceCount;
	}

	public static void resetCounts() {
		whitePieceCount = 0;
		blackPieceCount = 0;
	}

	protected Piece(Color color) {
		this.color = color;
		if (isWhite())
			Piece.incrementWhite();
		else
			Piece.incrementBlack();
	}

	public Color getColor() {
		return color;
	}

	public char getRepresentation() {
		if (isBlack())
			return Character.toUpperCase(getBaseRepresentation());
		return getBaseRepresentation();
	}

	abstract protected char getBaseRepresentation();

	protected double getBaseValue() {
		return 0.0;
	}

	public boolean isWhite() {
		return color.equals(Color.WHITE);
	}

	public boolean isBlack() {
		return color.equals(Color.BLACK);
	}

	/**
	 * This can be a volatile value, based on current board position. Overridden by
	 * certain pieces to account for board position
	 */
	public void setCurrentStrength(Board board, int rankIndex, int fileIndex) {
		strength = getBaseValue();
	}

	protected void setStrength(double strength) {
		this.strength = strength;
	}

	public double getStrength() {
		return strength;
	}

// order from strongest to weakest
	public int compareTo(Piece that) {
		if (this.strength < that.strength)
			return 1;
		if (this.strength > that.strength)
			return -1;
		return 0;
	}

	public List<String> getPossibleMoves(String square, Board board) {
		return new ArrayList<String>();
	}
}