package factories;

import models.*;
import strategies.InputStrategy;
import strategies.PlayingStrategy;

public class PlayerFactory {
    private static PlayerFactory instance = new PlayerFactory();

    public static PlayerFactory getInstance() {
        return instance;
    }

   public Player createHumanPlayer(User user, GameSymbol gameSymbol, InputStrategy inputStrategy) {
        return new HumanPlayer(user, gameSymbol, inputStrategy);
    }

    public Player createBot(PlayingStrategy playingStrategy, GameSymbol gameSymbol) {
        return new Bot(playingStrategy, gameSymbol);
    }
}
