package chessGame;

import chessGame.pieces.Piece;

public class Spot {

	public final int x;
	public final int y;
	private Piece<IColor> piece;

	public Piece<IColor> getPiece() {
		return piece;
	}

	public void setPiece(Piece<IColor> piece) {
		this.piece = piece;
	}

	public Spot(int x, int y) {
		this.x = x;
		this.y = y;
		this.piece = null;
	}

	public boolean isOccupied() {
		return null != this.piece;
	}

	public void occupy(Piece<IColor> piece) {
		if (null != this.piece) {
			this.piece.setAvailable(false);
		}
		this.piece = piece;
	}

	public Piece<IColor> release() {
		Piece<IColor> toBeReleased = this.piece;
		this.piece = null;
		return toBeReleased;
	}

}
