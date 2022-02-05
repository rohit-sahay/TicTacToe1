package models;

import strategies.InputStrategy;
import org.jetbrains.annotations.NotNull;

public class HumanPlayer extends Player {
    private User user;
    private InputStrategy inputStrategy;

    public HumanPlayer(User user, GameSymbol gameSymbol, InputStrategy inputStrategy) {
        super(gameSymbol);
        this.user = user;
        this.inputStrategy = inputStrategy;
    }

    public User getUser() {
        return user;
    }

    @Override
    public BoardCell move(@NotNull Board board) {
        board.printBoard();
        BoardCell cell = inputStrategy.getInput();
        cell.setGameSymbol(getGameSymbol());
        return cell;
    }

    @Override
    public PlayerType getPlayerType() {
        return PlayerType.HUMAN;
    }
}
