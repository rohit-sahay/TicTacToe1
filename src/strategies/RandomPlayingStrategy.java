package strategies;

import models.Board;
import models.BoardCell;

public class RandomPlayingStrategy implements PlayingStrategy {
    @Override
    public BoardCell play(Board board) {
        return board.getRandomAvailableCell();
    }
}
