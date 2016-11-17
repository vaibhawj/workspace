package chessGame;

import chessGame.players.BlackPlayer;
import chessGame.players.Player;
import chessGame.players.WhitePlayer;

public class Game {

	private Player<White> whitePlayer;

	private Player<Black> blackPlayer;

	private Board board;

	public Game() {
		board = new Board();
		whitePlayer = new WhitePlayer();
		blackPlayer = new BlackPlayer();
	}

}
