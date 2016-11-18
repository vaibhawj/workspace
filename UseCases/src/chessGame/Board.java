package chessGame;

public class Board {

	private Spot[][] spots;

	public Board() {
		spots = new Spot[8][8];

		for (int i = 0; i < spots.length; i++) {
			for (int j = 0; j < spots.length; j++) {
				this.spots[i][j] = new Spot(i, j);
			}
		}
	}

	public Spot getSpot(int x, int y) {
		return spots[x][y];
	}

}
