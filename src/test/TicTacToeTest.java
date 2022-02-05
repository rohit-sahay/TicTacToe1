package test;

import models.*;
import org.testng.annotations.Test;

import factories.PlayerFactory;
import strategies.CLIInputStrategy;
import strategies.DefaultWinningStrategy;
import strategies.RandomPlayingStrategy;
import java.util.List;
import java.util.Scanner;

import static org.testng.AssertJUnit.assertEquals;

public class TicTacToeTest {
    private Game game;

//    @Before
//    public void setUp() {
//        game = createGame();
//    }

    private Game createGame() {
        Game game = Game.builder()
                        .withDimensions(3, 3)
                        .withPlayer(PlayerFactory
                                        .getInstance()
                                        .createHumanPlayer(
                                            User.builder()
                                                .name("Rohit")
                                                .phone("9535277043")
                                                .build(),
                                                GameSymbol.X,
                                                new CLIInputStrategy(new Scanner(System.in))))
                        .withPlayer(PlayerFactory
                                        .getInstance()
                                        .createBot(new RandomPlayingStrategy(), GameSymbol.O))
                        .withWinningStrategy(new DefaultWinningStrategy())
                        .build();
        return game;
    }

    @Test
    public void testDimensions() {
        this.game = createGame();
        List<List<BoardCell>> cells = this.game.getBoard().getBoardCells();
        assertEquals(3, cells.size());
    }

    @Test
    public void testPlayer() {
        this.game = createGame();
        List<Player> players = this.game.getPlayers();
        for (Player player : players) {
            if (player.getPlayerType().equals(PlayerType.HUMAN)) {
                HumanPlayer humanPlayer = (HumanPlayer) player;
                assertEquals("Rohit", humanPlayer.getUser().getName());
                assertEquals("9535277043", humanPlayer.getUser().getPhone());
            } else {
                assertEquals(player.getPlayerType(), PlayerType.COMPUTER);
            }
        }
    }
}
