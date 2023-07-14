package chess;

import pieces.*;
import java.util.*;
import util.StringUtil;

public class Game {
	private Board board = new Board();
	private int pieceCount = 0;

	public void initialize() {
		Piece.resetCounts();
		addBlackBackRank();
		addBlackPawnRank();
		addWhitePawnRank();
		addWhiteBackRank();
		pieceCount = 32;
	}

	public int pieceCount() {
		return pieceCount;
	}

	public Piece get(String square) {
		return board.get(square);
	}

	public void put(String square, Piece piece) {
		board.put(square, piece);
	}

	Board getBoard() {
		return board;
	}

	private void addBlackBackRank() {
		put("a8", Piece.createBlackRook());
		put("b8", Piece.createBlackKnight());
		put("c8", Piece.createBlackBishop());
		put("d8", Piece.createBlackQueen());
		put("e8", Piece.createBlackKing());
		put("f8", Piece.createBlackBishop());
		put("g8", Piece.createBlackKnight());
		put("h8", Piece.createBlackRook());
	}

	private void addWhiteBackRank() {
		put("a1", Piece.createWhiteRook());
		put("b1", Piece.createWhiteKnight());
		put("c1", Piece.createWhiteBishop());
		put("d1", Piece.createWhiteQueen());
		put("e1", Piece.createWhiteKing());
		put("f1", Piece.createWhiteBishop());
		put("g1", Piece.createWhiteKnight());
		put("h1", Piece.createWhiteRook());
	}

	private void addWhitePawnRank() {
		put("a2", Piece.createWhitePawn());
		put("b2", Piece.createWhitePawn());
		put("c2", Piece.createWhitePawn());
		put("d2", Piece.createWhitePawn());
		put("e2", Piece.createWhitePawn());
		put("f2", Piece.createWhitePawn());
		put("g2", Piece.createWhitePawn());
		put("h2", Piece.createWhitePawn());
	}

	private void addBlackPawnRank() {
		put("a7", Piece.createBlackPawn());
		put("b7", Piece.createBlackPawn());
		put("c7", Piece.createBlackPawn());
		put("d7", Piece.createBlackPawn());
		put("e7", Piece.createBlackPawn());
		put("f7", Piece.createBlackPawn());
		put("g7", Piece.createBlackPawn());
		put("h7", Piece.createBlackPawn());
	}

	public String print() {
		StringBuilder builder = new StringBuilder();
		for (ArrayList<Piece> rank : board.ranks()) {
			StringBuilder line = new StringBuilder();
			for (Piece piece : rank)
				line.append(piece.getRepresentation());
			builder.append(StringUtil.appendNewLine(line.toString()));
		}
		return builder.toString();
	}

	public int count(Piece.Color color, Class klass) {
		int total = 0;
		for (List<Piece> rank : board.ranks())
			for (Piece piece : rank)
				if (piece.getColor().equals(color) && piece.getClass().equals(klass))
					total++;
		return total;
	}

	public List<Piece> piecesByStrength(Piece.Color color) {
		List<Piece> pieces = ratePiecesForStrength(color);
		Collections.sort(pieces);
		return pieces;
	}

	public double strength(Piece.Color color) {
		double strength = 0;
		List<Piece> pieces = ratePiecesForStrength(color);
		for (Piece piece : pieces)
			strength += piece.getStrength();
		return strength;
	}

	private List<Piece> ratePiecesForStrength(Piece.Color color) {
		List<Piece> pieces = new ArrayList<Piece>();
		int rankIndex = 0;
		for (List<Piece> rank : board.ranks()) {
			int fileIndex = 0;
			for (Piece piece : rank) {
				if (piece.getColor().equals(color)) {
					piece.setCurrentStrength(board, rankIndex, fileIndex);
					pieces.add(piece);
				}
				fileIndex++;
			}
			rankIndex++;
		}
		return pieces;
	}

	public List<String> getPossibleMoves(String square) {
		Piece piece = board.get(square);
		return piece.getPossibleMoves(square, board);
	}
}