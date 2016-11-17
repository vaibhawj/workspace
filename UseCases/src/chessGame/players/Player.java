package chessGame.players;

import java.util.ArrayList;
import java.util.List;

import chessGame.IColor;
import chessGame.Spot;
import chessGame.pieces.King;
import chessGame.pieces.Piece;
import chessGame.pieces.Queen;

public abstract class Player<V extends IColor> {

	private King<V> king;
	private Queen<V> queen;
	List<Piece<V>> pieces;

	public Player() {
		pieces = new ArrayList<>();
		king = new King<>();
		queen = new Queen<>();
		// TODO Similarly create all required pieces
		pieces.add(king);
		pieces.add(queen);
	}

	public void move(Spot fromSpot, Spot toSpot) {
		Piece<IColor> pieceToMove = fromSpot.getPiece();
		if (!isMovablePiece(pieceToMove)) {
			return;
		}

		boolean isValid = pieceToMove.isValidMove(fromSpot, toSpot);

	}

	private boolean isMovablePiece(Piece<IColor> pieceToMove) {
		return pieces.contains(pieceToMove);
	}

}
