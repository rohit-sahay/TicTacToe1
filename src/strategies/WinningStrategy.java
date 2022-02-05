package strategies;

import models.Board;

public interface WinningStrategy {
    public boolean isWinner(Board board);
}
