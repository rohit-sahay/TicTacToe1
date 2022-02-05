package controllers;

import factories.PlayerFactory;
import models.Game;
import models.GameSymbol;
import models.Player;
import models.User;
import strategies.CLIInputStrategy;
import strategies.DefaultWinningStrategy;
import strategies.RandomPlayingStrategy;

import java.util.Scanner;

public class CLIController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Please enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Please enter your symbol: (X or O)");
        String symbol = scanner.nextLine();
        GameSymbol gameSymbol = GameSymbol.valueOf(symbol.toUpperCase());
        Player player1 = PlayerFactory.getInstance()
                                        .createHumanPlayer(
                                                User.builder()
                                                        .name(name)
                                                        .build(),
                                                gameSymbol,
                                                new CLIInputStrategy(scanner));

        GameSymbol botSymbol = gameSymbol.equals(GameSymbol.X) ? GameSymbol.O : GameSymbol.X;
        Player bot = PlayerFactory.getInstance()
                                        .createBot(new RandomPlayingStrategy(), botSymbol);
        Game game = Game.builder()
                        .withDimensions(3, 3)
                        .withPlayer(player1)
                        .withPlayer(bot)
                        .withWinningStrategy(new DefaultWinningStrategy())
                        .build();

        game.startGame();
    }
}
