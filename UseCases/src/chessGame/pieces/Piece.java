package chessGame.pieces;

import chessGame.IColor;
import chessGame.Spot;

public abstract class Piece<V extends IColor> {

	private boolean available;

	public Piece() {
		this.available = true;
	}

	public final boolean isValidMove(Spot fromSpot, Spot toSpot) {
		if (toSpot.x == fromSpot.x && toSpot.y == fromSpot.y)
			return false;

		return isValidForPiece(fromSpot, toSpot);
	}

	protected abstract boolean isValidForPiece(Spot fromSpot, Spot toSpot);

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

}
