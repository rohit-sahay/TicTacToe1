package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Player {
    private GameSymbol gameSymbol;

    public Player(GameSymbol gameSymbol) {
        this.gameSymbol = gameSymbol;
    }
    public abstract BoardCell move(Board board);
    public abstract PlayerType getPlayerType();
}
