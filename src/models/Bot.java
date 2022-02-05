package models;

import strategies.PlayingStrategy;

public class Bot extends Player {
    private PlayingStrategy playingStrategy;

    public Bot(PlayingStrategy playingStrategy, GameSymbol gameSymbol) {
        super(gameSymbol);
        this.playingStrategy = playingStrategy;
    }

    public PlayingStrategy getPlayingStrategy() {
        return playingStrategy;
    }

    @Override
    public BoardCell move(Board board) {
        //board.printBoard();
        BoardCell cell = playingStrategy.play(board);
        return cell;
    }

    @Override
    public PlayerType getPlayerType() {
        return PlayerType.COMPUTER;
    }
}
